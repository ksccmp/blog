package com.mock.mockmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Post {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("리턴값 없이 테스트하는 방법")
    void postTest() throws Exception {
        // body 데이터 적재
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", "myName");
        requestMap.put("value", "myValue");

        String content = new ObjectMapper().writeValueAsString(requestMap);

        // api 요청
        mockMvc
                .perform(
                        post("/api/mock/postTest") // url
                                .contentType(MediaType.APPLICATION_JSON) // contentType 설정
                                .content(content) // body 데이터
                )
                .andDo(print()) // api 수행내역 로그 출력
                .andExpect(status().isOk()) // response status 200 검증
                .andExpect(jsonPath("method").value("POST")) // response method 데이터 검증
                .andExpect(jsonPath("name").value("myName")) // response name 데이터 검증
                .andExpect(jsonPath("value").value("myValue")); // response value 데이터 검증
    }

    @Test
    @DisplayName("리턴값을 이용하여 테스트하는 방법")
    void postTestReturn() throws Exception {
        // body 데이터 적재
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", "myName");
        requestMap.put("value", "myValue");

        String content = new ObjectMapper().writeValueAsString(requestMap);

        // api 요청
        MvcResult mvcResult = mockMvc
                .perform(
                        post("/api/mock/postTest") // url
                                .contentType(MediaType.APPLICATION_JSON) // contentType 설정
                                .content(content) // body 데이터
                )
                .andDo(print())
                .andReturn();

        // response 데이터 변환
        Map<String, String> responseMap =
                new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), Map.class);

        // 검증
        Assertions.assertEquals(responseMap.get("method"), "POST"); // response method 데이터 검증
        Assertions.assertEquals(responseMap.get("name"), "myName"); // response name 데이터 검증
        Assertions.assertEquals(responseMap.get("value"), "myValue"); // response value 데이터 검증
    }
}
