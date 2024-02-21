package com.jforj.springsecurityjwt.config;

import com.jforj.springsecurityjwt.exception.SecurityAccessDeniedHandler;
import com.jforj.springsecurityjwt.exception.SecurityAuthenticationEntryPoint;
import com.jforj.springsecurityjwt.filter.AuthenticationFilter;
import com.jforj.springsecurityjwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final SecurityAuthenticationEntryPoint securityAuthenticationEntryPoint;
    private final SecurityAccessDeniedHandler securityAccessDeniedHandler;

    private final JwtUtil jwtUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic(AbstractHttpConfigurer::disable) // 기본적인 security 설정은 사용하지 않음
                .csrf(AbstractHttpConfigurer::disable) // csrf 설정은 사용하지 않음
                .sessionManagement(AbstractHttpConfigurer::disable) // 기본적인 session 관리 설정 사용하지 않음
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests
                                        // /api/login API는 모든 사용자가 접근 가능
                                        .requestMatchers("/api/login").permitAll()
                                        // /api/admin API는 ROLE_ADMIN 권한이 있는 사용자만 접근 가능
                                        .requestMatchers("/api/admin").hasAuthority("ROLE_ADMIN")
                                        // /api/user API는 ROLE_ADMIN과 ROLE_USER 권한이 있는 사용자만 접근 가능
                                        // hasRole, hasAnyRole은 "ROLE_"을 prefix로 사용하지 않음
                                        .requestMatchers("/api/user").hasAnyRole("ADMIN", "USER")
                                        // 그 외 모든 요청에 대해서 인증된 사용자만 접근 가능
                                        .anyRequest().authenticated()
                )
                .formLogin(AbstractHttpConfigurer::disable) // 로그인 페이지 설정은 사용하지 않음
                .logout(AbstractHttpConfigurer::disable) // 로그아웃 페이지 설정은 사용하지 않음
                .addFilterBefore(
                        // spring security에 설정되어 있는 UsernamePasswordAuthenticationFilter 동작 전 커스텀 한 authenticationFilter 수행되도록 설정
                        new AuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class
                )
                .exceptionHandling(
                        exceptionHandling ->
                                exceptionHandling
                                        // 인증 문제가 발생될 경우 exception handling
                                        .authenticationEntryPoint(securityAuthenticationEntryPoint)
                                        // 인가 문제가 발생될 경우 exception handling
                                        .accessDeniedHandler(securityAccessDeniedHandler)
                )
        ;

        return httpSecurity.build();
    }
}
