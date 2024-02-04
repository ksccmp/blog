package com.jforj.servicetest.service;

import com.jforj.servicetest.annotation.ServiceTest;
import com.jforj.servicetest.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


// 모든 설정을 커스텀 어노테이션으로 한 개로 대체
@ServiceTest
class StudentServiceTest {

    // test에서만 사용되는 가짜 객체
    @Mock
    private StudentRepository studentRepository;

    // test에서만 사용되는 가짜 객체가 주입될 객체
    @InjectMocks
    private StudentService studentService;

    @Test
    void searchNamesTest() {
        // given
        List<String> givenNames = Arrays.asList("test1", "test2", "test3");
        // repository selectNames의 결과값을 test에서만 givenNames으로 변경
        when(studentRepository.selectNames()).thenReturn(givenNames);

        // when
        List<String> names = studentService.searchNames();

        // then
        assertEquals(3, names.size()); // 문자열 길이 검증
        for (String name : names) {
            assertFalse(name.contains("repository")); // 기존 로직에서 확인 가능한 repository 문자열 존재 검증
            assertTrue(name.contains("service")); // service 내부 로직인 formatting 수행 검증
        }
    }
}