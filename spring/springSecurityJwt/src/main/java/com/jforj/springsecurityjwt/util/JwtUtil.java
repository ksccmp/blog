package com.jforj.springsecurityjwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "123456781234567812345678123456781234567812345678"; // jwt token 생성에 사용될 secretKey
    private final long EXPIRE_TIME = 1000L * 60 * 60; // token 사용 시간, 1시간
    private final String USER_ID = "userId"; // claim에 담길 사용자 아이디 key

    /**
     * token 생성
     *
     * @param userId 사용자 아이디
     * @return 생성된 token
     */
    public String createToken(String userId) {
        return Jwts
                .builder()
                .setSubject("accessToken") // token 제목 설정
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // token 유효 시간 설정
                .claim(USER_ID, userId) // token에 담아 둘 데이터 설정
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(SECRET_KEY)), SignatureAlgorithm.HS256) // token 암호화 처리 (해싱 알고리즘)
                .compact(); // 직렬화 처리 (string으로 변경)
    }

    /**
     * token을 이용하여 사용자 아이디 조회
     *
     * @param token 발급된 token
     * @return token에 담겨있는 사용자 아이디
     */
    public String getUserId(String token) {
        return getTokenClaim(token).get(USER_ID).toString();
    }

    /**
     * token의 claim 정보 조회
     *
     * @param token 발급된 token
     * @return token에 담겨있는 claim 정보
     */
    private Map<String, Object> getTokenClaim(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(SECRET_KEY)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
