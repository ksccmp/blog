package com.jforj.swagger.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Tag(name = "user controller api", description = "사용자 처리에 사용되는 API")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames() {
        List<String> names = Arrays.asList(
                "김이름",
                "최이름",
                "진이름"
        );

        return ResponseEntity.ok(names);
    }
}
