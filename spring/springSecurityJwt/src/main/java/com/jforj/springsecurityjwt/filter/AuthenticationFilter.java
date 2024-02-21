package com.jforj.springsecurityjwt.filter;

import com.jforj.springsecurityjwt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class AuthenticationFilter extends GenericFilterBean {

    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer";

    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // header에서 token 정보를 확인
        // token은 header 내부에 { Authorization: BEARER qkwne9Asd~~ } 와 같이 담김
        String token = ((HttpServletRequest) request).getHeader(AUTHORIZATION);

        // token이 있는 경우에만 securityContext에 Authentication 저장하는 로직 동작
        if (StringUtils.hasText(token)) {
            // BEARER을 제거한 token 값을 이용하여 사용자 아이디 조회
            String userId = jwtUtil.getUserId(token.substring(BEARER.length() + 1));

            // *** DB or 외부 API로부터 사용자 정보 및 권한 정보를 조회하는 구간 ***
            // *** 해당 코드에서는 구현하지 않기 때문에 정보를 조회하지 않고 더미 데이터를 활용 ***

            List<GrantedAuthority> userRoles = new ArrayList<>();
            switch (userId) {
                // 로그인한 사용자가 admin인 경우 ROLE_ADMIN, ROLE_USER 권한 부여
                case "admin": {
                    userRoles = Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")});
                    break;
                }

                // 로그인한 사용자가 user인 경우 ROLE_USER 권한 부여
                case "user": {
                    userRoles = Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")});
                    break;
                }
            }

            // securityContext에 보관해 둘 Authentication 정보 구성
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userId,
                            null, // 비밀번호는 로그인 할 때 확인하기 때문에 담아둘 필요 없음
                            userRoles
                    );

            // securityContext에 Authentication 보관
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // filter 처리 이후 요청 수행
        chain.doFilter(request, response);
    }
}
