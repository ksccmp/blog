package com.spring.querydsl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.querydsl.repository.StudentQueryRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BootQuerydslProjectionsApplicationTests {
	
	@Autowired
	StudentQueryRepository studentQueryRepository;

	@Test
	void someStudentTest() {
		log.info(studentQueryRepository.findForSomeStudentList().toString());
	}
}
