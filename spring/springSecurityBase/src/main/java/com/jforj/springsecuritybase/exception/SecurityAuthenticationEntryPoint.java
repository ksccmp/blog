package com.jforj.springsecuritybase.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8"); // response encoding 설정
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // response http status 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); // response content-type 설정
        response.getWriter().write("인증에 실패했습니다."); // response data 설정
    }
}
