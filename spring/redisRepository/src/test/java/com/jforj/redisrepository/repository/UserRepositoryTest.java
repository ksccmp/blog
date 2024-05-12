package com.jforj.redisrepository.repository;

import com.jforj.redisrepository.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void create() {
        List<User> users = List.of(
                User.builder()
                        .id("first id")
                        .name("first name")
                        .expiration(60L) // TTL 60초
                        .build(),
                User.builder()
                        .id("second id")
                        .name("second name")
                        .expiration(30L) // TTL 30초
                        .build()
        );

        userRepository.saveAll(users);
    }

    @Test
    void selectAll() {
        userRepository.findAll().forEach(user -> System.out.println(user));
    }

    @Test
    void selectName() {
        System.out.println(userRepository.findByName("first name"));
    }
}