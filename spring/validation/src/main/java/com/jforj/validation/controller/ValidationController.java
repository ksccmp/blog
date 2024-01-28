package com.jforj.validation.controller;

import com.jforj.validation.dto.GetDto;
import com.jforj.validation.dto.PostDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ValidationController {

    @GetMapping("/get/param")
    public ResponseEntity<GetDto> getParam(
            @NotBlank String name, // null, 빈 문자열, 공백으로만 이루어진 문자열이 들어오는 경우 exception 발생
            @Min(10) Long age // 10보다 작은 값이 들어오는 경우 exception 발생
    ) {
        log.info("name: {}", name);
        log.info("age: {}", age);

        return ResponseEntity.ok(
                GetDto
                        .builder()
                        .name(name)
                        .age(age)
                        .build()
        );
    }

    @GetMapping("/get/object")
    public ResponseEntity<GetDto> getObject(
            @Valid GetDto getDto // @Valid를 추가해야 GetDto에 설정된 유효성 검증 수행
    ) {
        log.info("name: {}", getDto.name());
        log.info("age: {}", getDto.age());

        return ResponseEntity.ok(getDto);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> post(@RequestBody @Valid PostDto postDto) {
        log.info("name: {}", postDto.name());
        log.info("age: {}", postDto.age());

        return ResponseEntity.ok(postDto);
    }
}
