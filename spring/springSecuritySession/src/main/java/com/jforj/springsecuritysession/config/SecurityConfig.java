package com.jforj.springsecuritysession.config;

import com.jforj.springsecuritysession.exception.SecurityAccessDeniedHandler;
import com.jforj.springsecuritysession.exception.SecurityAuthenticationEntryPoint;
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
    private final SecurityAuthenticationEntryPoint securityAuthenticationEntryPoint;
    private final SecurityAccessDeniedHandler securityAccessDeniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic(Customizer.withDefaults()) // 기본적인 security 설정 적용
                .csrf(AbstractHttpConfigurer::disable) // csrf 설정은 사용하지 않음
                .sessionManagement(Customizer.withDefaults()) // 기본적인 session 관리 설정 적용
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests
                                        // /page/login 페이지와 /page/logout 페이지는 모든 사용자가 접근 가능
                                        .requestMatchers("/page/login", "/page/logout").permitAll()
                                        // /page/admin 페이지는 ROLE_ADMIN 권한이 있는 사용자만 접근 가능
                                        .requestMatchers("/page/admin").hasAuthority("ROLE_ADMIN")
                                        // /page/user 페이지는 ROLE_ADMIN과 ROLE_USER 권한이 있는 사용자만 접근 가능
                                        // hasRole, hasAnyRole은 "ROLE_"을 prefix로 사용하지 않음
                                        .requestMatchers("/page/user").hasAnyRole("ADMIN", "USER")
                                        // 그 외 모든 요청에 대해서 인증된 사용자만 접근 가능
                                        .anyRequest().authenticated()
                )
                .formLogin(
                        formLogin ->
                                formLogin
                                        // 로그인 페이지 URL 설정
                                        .loginPage("/page/login")
                                        // form action 처리가 이루어질 때 username이 담겨야 하는 parameter name (ex, <input type="text" name="id" />)
                                        .usernameParameter("id")
                                        // form action 처리가 이루어질 때 password가 담겨야 하는 parameter name (ex, <input type="password" name="password" />)
                                        .passwordParameter("password")
                                        // security에 의해 로그인 프로세스가 자동으로 이루어지는 URL (form action 경로에 사용)
                                        // controller에서 따로 구현 필요 없음
                                        .loginProcessingUrl("/login")
                                        // 로그인이 이루어질 때 이동되는 URL 설정
                                        .defaultSuccessUrl("/page/user")
                )
                .logout(
                        logout ->
                                logout
                                        // security에 의해 로그아웃 프로세스가 자동으로 이루어지는 URL (form action 경로에 사용)
                                        // controller에서 따로 구현 필요 없음
                                        .logoutUrl("/logout")
                                        // 로그아웃이 이루어질 때 이동되는 URL 설정
                                        .logoutSuccessUrl("/page/logout")
                                        // 로그아웃 이후 세션 초기화 설정
                                        .invalidateHttpSession(true)
                                        // 로그아웃 이후 쿠키 삭제 설정
                                        .deleteCookies("JSESSIONID")
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
