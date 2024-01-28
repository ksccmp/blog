package com.jforj.validation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jforj.validation.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getParamTest() throws Exception {
        mockMvc
                .perform(
                        get("/get/param")
                                // name이 paramter에서 제외됨
                                .param("age", "10")
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getObjectTest() throws Exception {
        mockMvc
                .perform(
                        get("/get/object")
                                // name이 paramter에서 제외됨
                                .param("age", "10")
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void postTest() throws Exception {
        PostDto postDto =
                PostDto
                        .builder()
                        // name이 paramter에서 제외됨
                        .age(10L)
                        .build();

        mockMvc
                .perform(
                        post("/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(postDto))
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}