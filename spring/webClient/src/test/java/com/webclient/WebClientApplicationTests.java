package com.webclient;

import com.webclient.service.WebClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebClientApplicationTests {

    @Autowired
    private WebClientServiceImpl webClientService;

    @Test
    void get() {
        webClientService.get();
    }

    @Test
    void getEntity() {
        webClientService.getEntity();
    }

    @Test
    void getFlux() {
        webClientService.getFlux();
    }

    @Test
    void getMultiple() {
        webClientService.getMultiple();
    }

    @Test
    void post() {
        webClientService.post();
    }
}
