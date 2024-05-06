package com.jforj.repositorymemorytestconfig.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

// JPA 테스트 코드 구성 설정을 도와주는 어노테이션 ( + @Repository 관련 설정 포함)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
// 프로젝트에서 설정한 DB를 사용하고 싶은 경우 다음과 같이 설정
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// test profile 설정 기반으로 테스트 동작 설정
@ActiveProfiles("test")
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void insertAndSelectNames() {
        // given
        String givenName = "테스트 이름";
        int givenAge = 10;
        long givenSchoolNo = 2;

        // when
        List<String> names =
                studentRepository
                        .insertAndSelectNames(null, givenAge, givenSchoolNo);

        // then
        assertTrue(names.contains(givenName));
    }
}