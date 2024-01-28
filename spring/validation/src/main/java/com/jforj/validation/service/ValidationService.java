package com.jforj.validation.service;

import com.jforj.validation.dto.GetDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated // @Validated를 추가해야 클래스 내부에서 설정된 유효성 검증 수행
@Slf4j
public class ValidationService {

    public GetDto getParam(
            @NotBlank String name, // null, 빈 문자열, 공백으로만 이루어진 문자열이 들어오는 경우 exception 발생
            @Min(10) Long age // 10보다 작은 값이 들어오는 경우 exception 발생
    ) {
        log.info("name: {}", name);
        log.info("age: {}", age);

        return GetDto
                .builder()
                .name(name)
                .age(age)
                .build();
    }

    public GetDto getObject(
            @Valid GetDto getDto // @Valid를 추가해야 GetDto에 설정된 유효성 검증 수행
    ) {
        log.info("name: {}", getDto.name());
        log.info("age: {}", getDto.age());

        return getDto;
    }
}
