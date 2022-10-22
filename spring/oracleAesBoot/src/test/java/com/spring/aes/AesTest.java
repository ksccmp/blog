package com.spring.aes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.aes.util.Aes;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AesTest {
	
	@Autowired
	Aes aes;

	@Test
	void aesTest() {
		log.info(aes.encryption("oracle-spring"));
		log.info(aes.decryption("VgBxHhzcvkFIpizGhWX9aQ=="));
	}
}
