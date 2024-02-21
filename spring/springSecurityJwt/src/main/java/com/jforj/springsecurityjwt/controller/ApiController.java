package com.jforj.springsecurityjwt.controller;

import com.jforj.springsecurityjwt.dto.LoginRequestDto;
import com.jforj.springsecurityjwt.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final String AUTHORIZATION = "Authorization";

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) throws AuthenticationException {
        // *** DB or 외부 API로부터 사용자 로그인 처리를 하는 구간 ***
        // *** 해당 코드에서는 구현하지 않기 때문에 정보를 조회하지 않고 더미 데이터를 활용 ***

        if (!"password".equals(loginRequestDto.password())) {
            throw new AuthenticationException("로그인에 실패했습니다.");
        }

        // userId 기반으로 token 생성
        String token = jwtUtil.createToken(loginRequestDto.userId());
        // header에 token 정보를 담아 client에 전달
        response.setHeader(AUTHORIZATION, token);

        return ResponseEntity.ok("로그인 되었습니다.");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("admin");
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("user");
    }
}
