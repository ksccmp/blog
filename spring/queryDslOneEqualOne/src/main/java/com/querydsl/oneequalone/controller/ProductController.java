package com.querydsl.oneequalone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin("*")
public class ProductController {

    @GetMapping("/api/get")
    public ResponseEntity<Object> apiGet(String code) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", "Success");

        return ResponseEntity.ok(map);
    }

    @PostMapping("/api/post")
    public ResponseEntity<Object> apiPost(@RequestBody Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("name", map.get("name"));
        resMap.put("age", map.get("age"));
        resMap.put("message", "Success ");

        return ResponseEntity.ok(resMap);
    }
}
