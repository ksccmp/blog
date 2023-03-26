package com.kakao.login.controller;

import com.kakao.login.dto.KakaoLogin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class KakaoLoginController {

    private String kakaoUrl = "https://kauth.kakao.com";
    private String kakaoApiUrl = "https://kapi.kakao.com";
    private String clientId = "6fd6a723923f45ee818dc814ec14a844"; // 앱 키 중 REST API 키

    @PostMapping("/api/kakao/login")
    public ResponseEntity<Object> kakaoLogin(@RequestBody KakaoLogin kakaoLogin) {
        /**
         * code값을 이용하여 token정보 가져오기
         */
        // webClient 설정
        WebClient kakaoWebClient =
                WebClient.builder()
                        .baseUrl(kakaoUrl)
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();

        // token api 호출
        Map<String, Object> tokenResponse =
                kakaoWebClient
                        .post()
                        .uri(uriBuilder -> uriBuilder
                                .path("/oauth/token")
                                .queryParam("grant_type", "authorization_code")
                                .queryParam("client_id", clientId)
                                .queryParam("code", kakaoLogin.getCode())
                                .build())
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        String accessToken = (String) tokenResponse.get("access_token");

        /**
         * accessToken으로 로그인 사용자가 동의한 정보 확인하기
         */
        // webClient 설정
        WebClient kakaoApiWebClient =
                WebClient.builder()
                        .baseUrl(kakaoApiUrl)
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();

        // info api 설정
        Map<String, Object> infoResponse =
                kakaoApiWebClient
                        .post()
                        .uri(uriBuilder -> uriBuilder
                                .path("/v2/user/me")
                                .build())
                        .header("Authorization", "Bearer " + accessToken)
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        Map<String, Object> kakaoAccountMap = (Map<String, Object>) infoResponse.get("kakao_account");
        Map<String, String> profileMap = (Map<String, String>) kakaoAccountMap.get("profile");
        Map<String, String> responseMap = new HashMap<>();

        // 닉네임 정보 담기
        if (StringUtils.hasText(profileMap.get("nickname"))) {
            responseMap.put("nickname", profileMap.get("nickname"));
        }
        // 프로필 사진 정보 담기
        if (StringUtils.hasText(profileMap.get("profile_image_url"))) {
            responseMap.put("profileImageUrl", profileMap.get("profile_image_url"));
        }
        // 이메일 정보 담기
        if ("true".equals(kakaoAccountMap.get("has_email").toString())) {
            responseMap.put("email", kakaoAccountMap.get("email").toString());
        }
        // 성별 정보 담기
        if ("true".equals(kakaoAccountMap.get("has_gender").toString())) {
            responseMap.put("gender", kakaoAccountMap.get("gender").toString());
        }
        // 연령대 정보 담기
        if ("true".equals(kakaoAccountMap.get("has_age_range").toString())) {
            responseMap.put("ageRange", kakaoAccountMap.get("age_range").toString());
        }
        // 생일 정보 담기
        if ("true".equals(kakaoAccountMap.get("has_birthday").toString())) {
            responseMap.put("birthday", kakaoAccountMap.get("birthday").toString());
        }

        // 결과 반환
        return ResponseEntity.ok(responseMap);
    }
}
