package com.mock.mockmvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostRestTemplate {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void postTestTemplate() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", "myName");
        requestMap.put("value", "myValue");

        Map<String, String> responseMap =
                testRestTemplate
                        .postForObject("/api/mock/postTest", requestMap, Map.class);

        Assertions.assertEquals(responseMap.get("method"), "POST");
        Assertions.assertEquals(responseMap.get("name"), "myName");
        Assertions.assertEquals(responseMap.get("value"), "myValue");
    }
}
