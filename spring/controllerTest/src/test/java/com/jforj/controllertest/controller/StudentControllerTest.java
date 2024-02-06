package com.jforj.controllertest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jforj.controllertest.annotation.ControllerTest;
import com.jforj.controllertest.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 모든 설정을 커스텀 어노테이션으로 한 개로 대체
@ControllerTest
class StudentControllerTest {

    // service에서 mock 객체를 사용하지 않고 실제 service 객체를 사용
    @Autowired
    private StudentService studentService;

    // api 호출을 위해 사용되는 mockMvc
    @Autowired
    private MockMvc mockMvc;

    // api 호출 응답값 구성을 위한 objectMapper
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getNamesTest() throws Exception {
        // given
        // service searchNames 반환값 설정 제거

        // when
        MvcResult mvcResult = mockMvc
                .perform(
                        get("/names")
                )
                .andDo(print()) // api 수행내역 로그 출력
                .andExpect(status().isOk()) // response status 200 검증
                .andReturn();

        // response 값을 List 구조로 변환
        List<String> names = objectMapper.readValue(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()), List.class);

        // then
        assertEquals(2, names.size()); // 문자열 길이 검증
        for (String name : names) {
            assertTrue(name.contains("service")); // 기존 로직에서 확인 가능한 service 문자열 존재 검증
            assertTrue(name.contains("controller")); // controller 내부 로직인 formatting 수행 검증
        }
    }
}