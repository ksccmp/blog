package com.mock.mockmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Get {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("리턴값 없이 테스트하는 방법")
    void getTest() throws Exception {
        // api 요청
        mockMvc
                .perform(
                        get("/api/mock/getTest") // url
                                .param("name", "myName") // parameter
                                .param("value", "myValue") // parameter
                )
                .andDo(print()) // api 수행내역 로그 출력
                .andExpect(status().isOk()) // response status 200 검증
                .andExpect(jsonPath("method").value("GET")) // response method 데이터 검증
                .andExpect(jsonPath("name").value("myName")) // response name 데이터 검증
                .andExpect(jsonPath("value").value("myValue")); // response value 데이터 검증
    }

    @Test
    @DisplayName("리턴값을 이용하여 테스트하는 방법")
    void getTestReturn() throws Exception {
        // api 요청
        MvcResult mvcResult = mockMvc
                .perform(
                        get("/api/mock/getTest") // url
                                .param("name", "myName") // parameter
                                .param("value", "myValue") // parameter
                )
                .andDo(print())
                .andReturn();

        // response 데이터 변환
        Map<String, String> responseMap =
                new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), Map.class);

        // 검증
        Assertions.assertEquals(responseMap.get("method"), "GET"); // response method 데이터 검증
        Assertions.assertEquals(responseMap.get("name"), "myName"); // response name 데이터 검증
        Assertions.assertEquals(responseMap.get("value"), "myValue"); // response value 데이터 검증
    }
}
