package com.jforj.servicetest.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    public List<String> selectNames() {
        return Arrays.asList("repository1", "repositroy2");
    }
}
