package com.apple.login.controller;

import com.apple.login.dto.AppleLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.SignedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.*;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;

@RestController
public class AppleLoginController {

    /**
     * Apple Login에 사용되는 변수 (실 사용시엔 properties에서 관리하기)
     */
    private String appleUrl = "https://appleid.apple.com";
    private String appleKeyId = "389FGAM98S"; // Key 생성할 때 만들어진 Key ID
    private String appleKeyIdPath = "/keys/AuthKey_389FGAM98S.p8"; // Key 생성할 때 다운로드한 p8 파일 경로
    private String appleKey = "org.nextjs.jforj"; // Service IDs 생성할 때 등록한 identifer
    private String appleTeamId = ""; // App 생성할 때 등록된 App ID Prefix


    @PostMapping("/api/apple/login")
    public ResponseEntity<Object> appleLogin(@RequestBody AppleLogin appleLogin) throws Exception {
        /**
         * appleKeyId를 이용하여 privateKey 생성
         */

        // appleKeyId에 담겨있는 정보 가져오기
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(appleKeyIdPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((readLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(readLine);
            stringBuilder.append("\n");
        }
        String keyPath = stringBuilder.toString();

        // privateKey 생성하기
        Reader reader = new StringReader(keyPath);
        PEMParser pemParser = new PEMParser(reader);
        JcaPEMKeyConverter jcaPEMKeyConverter = new JcaPEMKeyConverter();
        PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) pemParser.readObject();
        PrivateKey privateKey = jcaPEMKeyConverter.getPrivateKey(privateKeyInfo);

        /**
         * privateKey를 이용하여 clientSecretKey 생성
         */

        // headerParams 적재
        Map<String, Object> headerParamsMap = new HashMap<>();
        headerParamsMap.put("kid", appleKeyId);
        headerParamsMap.put("alg", "ES256");

        // clientSecretKey 생성
        String clientSecretKey = Jwts
                .builder()
                .setHeaderParams(headerParamsMap)
                .setIssuer(appleTeamId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 30)) // 만료 시간 (30초)
                .setAudience(appleUrl)
                .setSubject(appleKey)
                .signWith(SignatureAlgorithm.ES256, privateKey)
                .compact();

        /**
         * code값을 이용하여 token정보 가져오기
         */

        // webClient 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl(appleUrl)
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();

        // token api 호출
        Map<String, Object> tokenResponse =
                webClient
                        .post()
                        .uri(uriBuilder -> uriBuilder
                                .path("/auth/token")
                                .queryParam("grant_type", "authorization_code")
                                .queryParam("client_id", appleKey)
                                .queryParam("client_secret", clientSecretKey)
                                .queryParam("code", appleLogin.getCode())
                                .build())
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        String idToken = (String) tokenResponse.get("id_token");

        /**
         * apple public key로 idToken을 복호화하여 사용자 이메일 정보 확인하기
         */

        // key api 호출
        Map<String, Object> keyReponse =
                webClient
                        .get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/auth/keys")
                                .build())
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        List<Map<String, Object>> keys = (List<Map<String, Object>>) keyReponse.get("keys");

        // 가져온 public key 중 idToken을 암호화한 key가 있는지 확인
        SignedJWT signedJWT = SignedJWT.parse(idToken);
        for (Map<String, Object> key : keys) {
            RSAKey rsaKey = (RSAKey) JWK.parse(new ObjectMapper().writeValueAsString(key));
            RSAPublicKey rsaPublicKey = rsaKey.toRSAPublicKey();
            JWSVerifier jwsVerifier = new RSASSAVerifier(rsaPublicKey);

            // idToken을 암호화한 key인 경우
            if (signedJWT.verify(jwsVerifier)) {
                // jwt를 .으로 나눴을때 가운데에 있는 payload 확인
                String payload = idToken.split("[.]")[1];
                // public key로 idToken 복호화
                Map<String, Object> payloadMap = new ObjectMapper().readValue(new String(Base64.getDecoder().decode(payload)), Map.class);
                // 사용자 이메일 정보 추출
                String email = payloadMap.get("email").toString();

                // 결과 반환
                return ResponseEntity.ok(email);
            }
        }

        // 결과 반환
        return null;
    }
}
