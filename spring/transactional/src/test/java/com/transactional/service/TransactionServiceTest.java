package com.transactional.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void create() {
        transactionService.create();
    }

    @Test
    void createError() {
        transactionService.createError();
    }

    @Test
    void getContents() {
        System.out.println(transactionService.getContents());
    }
}