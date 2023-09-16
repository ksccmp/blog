package com.jacoco.service;

import com.jacoco.dto.JacocoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JacocoService {

    private static long count = 0;

    public void increaseCount() {
        count++;
    }

    public JacocoDto getJacocoDto() {
        if (count > 5) {
            return JacocoDto
                    .builder()
                    .title("count가 5보다 크네")
                    .count(count)
                    .build();
        } else {
            return JacocoDto
                    .builder()
                    .title("count가 5보다 작은데...")
                    .count(count)
                    .build();
        }
    }

    public void doNotMakeTestCase() {
        log.info("여기는 테스트 코드를 작성하는 메서드가 아닙니다.");
    }
}
