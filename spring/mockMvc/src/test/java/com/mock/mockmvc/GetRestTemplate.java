package com.mock.mockmvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetRestTemplate {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getTestTemplate() {
        Map<String, String> responseMap =
                testRestTemplate
                        .getForObject("/api/mock/getTest?name=myName&value=myValue", Map.class);

        Assertions.assertEquals(responseMap.get("method"), "GET");
        Assertions.assertEquals(responseMap.get("name"), "myName");
        Assertions.assertEquals(responseMap.get("value"), "myValue");
    }
}
