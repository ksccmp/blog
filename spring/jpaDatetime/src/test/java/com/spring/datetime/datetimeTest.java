package com.spring.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datetime.entity.Jpadatetime;
import com.spring.datetime.repository.JpadatetimeRepository;

@SpringBootTest
class datetimeTest {
	
	@Autowired
	JpadatetimeRepository jpadatetimeRepository;

	@Test
	void insert() {
		Jpadatetime jpadatetime = Jpadatetime.builder()
											 .name("J4J")
											 .createId("J4J")
											 .updateId("J4J")
											 .build();
		
		jpadatetimeRepository.save(jpadatetime);
	}
	
//	@Test
//	void update() {
//		Jpadatetime jpadatetime = jpadatetimeRepository.findById(1).get();
//		jpadatetime.setUpdateId("updateId");
//		
//		jpadatetimeRepository.save(jpadatetime);
//	}
}
