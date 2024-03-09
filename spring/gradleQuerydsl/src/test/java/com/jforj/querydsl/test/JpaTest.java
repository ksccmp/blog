package com.jforj.querydsl.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class JpaTest {

    @Autowired
    private ChildJpaRepository childJpaRepository;

    @Autowired
    private ParentJpaRepository parentJpaRepository;

    @Autowired
    private MyService myService;

    @Test
    void childSelectTest() {
        log.info("child, {}", childJpaRepository.findAll());
    }

    @Test
    void parentSelectTest() {
        log.info("parent, {}", parentJpaRepository.findAll());
    }

    @Test
    void childSaveTest() {
        myService.childSaveTest();
    }

    @Test
    void parentSaveTest() {
        myService.parentSaveTest();
    }

    @Test
    void parentUpdateTest() {
        myService.parentUpdateTest();
    }

    @Test
    void childDeleteTest() {
        myService.childDeleteTest();
    }

    @Test
    void parentDeleteTest() {
        myService.parentDeleteTest();
    }
}
