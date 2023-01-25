package com.querydsl.oneequalone;

import com.querydsl.oneequalone.repository.SchoolQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class QueryDslOneEqualOneApplicationTests {

    @Autowired
    private SchoolQueryRepository schoolQueryRepository;

    @Test
    void oneToOneTest() {
        log.info(schoolQueryRepository.findOfOneEqualsOne().toString());
    }
}
