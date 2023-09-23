package com.localdatetime.controller;

import com.localdatetime.dto.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LocalDateTimeController {
//
//    @GetMapping("/get")
//    public Object get(LocalDateTime date) {
//        log.info(date.toString()); // 2023-09-21T23:12:11
//        return ResponseEntity.ok(date);
//    }

    @PostMapping("/post")
    public Object post(@RequestBody PostDto postDto) {
        log.info(postDto.getDate().toString()); // 2023-09-21T23:12:11
        return ResponseEntity.ok(postDto.getDate());
    }
}
