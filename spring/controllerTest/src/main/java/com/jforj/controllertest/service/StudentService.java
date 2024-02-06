package com.jforj.controllertest.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<String> searchNames() {
        return Arrays.asList("service1", "service2");
    }
}
