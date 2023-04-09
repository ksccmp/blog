package com.mock.mockmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    @GetMapping("/getTest")
    public ResponseEntity<Object> getTest(String name, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("method", "GET");
        map.put("name", name);
        map.put("value", value);

        return ResponseEntity.ok(map);
    }

    @PostMapping("/postTest")
    public ResponseEntity<Object> postTest(@RequestBody Map<String, String> map) {
        map.put("method", "POST");

        return ResponseEntity.ok(map);
    }
}
