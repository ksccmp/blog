package com.jforj.validation.service;

import com.jforj.validation.dto.GetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;

    @Test
    void getParam() {
        validationService.getParam(
                null, // name은 null 처리
                10L
        );
    }

    @Test
    void getObject() {
        GetDto getDto =
                GetDto
                        .builder()
                        // name은 제외됨
                        .age(10L)
                        .build();

        validationService.getObject(getDto);
    }
}