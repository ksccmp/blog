package com.jforj.springsecuritybase.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic(Customizer.withDefaults()) // 기본적인 security 설정 적용
                .csrf(AbstractHttpConfigurer::disable) // csrf 설정은 사용하지 않음
                .sessionManagement(Customizer.withDefaults()) // 기본적인 session 관리 설정 적용
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests
                                        .anyRequest().authenticated() // 모든 요청에 대해서 인증된 사용자만 접근 가능
                )
                .formLogin(
                        formLogin ->
                                formLogin
                                        .successHandler(
                                                (request, response, authentication) -> {
                                                    response.sendRedirect("/home"); // 로그인이 성공하면 /home으로 이동
                                                }
                                        )
                                        .permitAll() // 로그인 페이지는 모든 사용자에게 허용
                )
//                .exceptionHandling(
//                        exceptionHandling ->
//                                exceptionHandling
//                                        .authenticationEntryPoint(securityAuthenticationEntryPoint) // 인증 문제가 발생될 경우 exception handling
//                                        .accessDeniedHandler(securityAccessDeniedHandler) // 인가 문제가 발생될 경우 exception handling
//                )
        ;

        return httpSecurity.build();
    }
}
