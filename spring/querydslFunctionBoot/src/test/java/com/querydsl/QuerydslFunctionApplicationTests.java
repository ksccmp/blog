package com.querydsl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.repository.FunctionRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class QuerydslFunctionApplicationTests {
	
	@Autowired
	FunctionRepository functionRepository;

	@Test
	void functionTest() {
		log.info(functionRepository.function().toString());
	}
}
