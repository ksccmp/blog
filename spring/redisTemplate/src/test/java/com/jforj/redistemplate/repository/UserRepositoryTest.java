package com.jforj.redistemplate.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void create() {
        userRepository.create("first id", "first name", 60L); // 60초 후 파기
        userRepository.create("second id", "second name", 30L); // 30초 후 파기
    }

    @Test
    void selectAll() {
        userRepository.selectAll();
    }
}