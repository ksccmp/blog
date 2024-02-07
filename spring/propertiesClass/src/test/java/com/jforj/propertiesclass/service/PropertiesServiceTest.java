package com.jforj.propertiesclass.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertiesServiceTest {

    @Autowired
    private PropertiesService propertiesService;

    @Test
    void printTest() {
        propertiesService.print();
    }
}