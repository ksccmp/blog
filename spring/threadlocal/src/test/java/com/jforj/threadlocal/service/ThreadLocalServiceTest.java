package com.jforj.threadlocal.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadLocalServiceTest {

    @Autowired
    private ThreadLocalService threadLocalService;

    @Test
    void getName() {
        threadLocalService.getName("1234");
    }
}