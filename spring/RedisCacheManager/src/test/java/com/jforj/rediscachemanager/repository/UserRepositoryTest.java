package com.jforj.rediscachemanager.repository;

import com.jforj.rediscachemanager.entity.User;
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
        userRepository.create("first id", "first name");
        userRepository.create("second id", "second name");
    }

    @Test
    void selectAll() {
        List<User> users = userRepository.selectAll();
        System.out.println(users);
    }

    @Test
    void delete() {
        userRepository.delete("first id");
    }
}