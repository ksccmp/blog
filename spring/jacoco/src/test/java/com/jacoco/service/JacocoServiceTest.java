package com.jacoco.service;

import com.jacoco.dto.JacocoDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class JacocoServiceTest {

    @Autowired
    private JacocoService jacocoService;

    @Test
    @DisplayName("count가 5보다 크게 나오는 경우 테스트")
    void countGreaterThanFive() {
        for (int i = 0; i <= 5; i++) {
            jacocoService.increaseCount();
        }

        JacocoDto jacocoDto = jacocoService.getJacocoDto();
        log.info("jacocoDto= {}", jacocoDto);
        Assertions.assertTrue(jacocoDto.getCount() > 5);
    }
}