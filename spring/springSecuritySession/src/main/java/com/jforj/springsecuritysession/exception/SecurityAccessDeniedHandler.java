package com.jforj.springsecuritysession.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8"); // response encoding 설정
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // response http status 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); // response content-type 설정
        response.getWriter().write("권한이 존재하지 않습니다."); // response data 설정
    }
}
