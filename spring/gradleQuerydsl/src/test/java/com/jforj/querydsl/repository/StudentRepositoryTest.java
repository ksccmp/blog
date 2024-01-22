package com.jforj.querydsl.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void createStudent() {
        studentRepository.createStudent("test name", 100);
    }

    @Test
    void selectStudentInfo() {
        log.info(
                studentRepository.selectStudentInfo().toString()
        );
    }
}