package com.querydsl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.repository.ConstantRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class QuerydslConstantBootApplicationTests {
	
	@Autowired
	ConstantRepository constantRepsitory;

	@Test
	void test() {
		log.info(constantRepsitory.stringContant().toString());
		log.info(constantRepsitory.numberContant().toString());
	}
}
