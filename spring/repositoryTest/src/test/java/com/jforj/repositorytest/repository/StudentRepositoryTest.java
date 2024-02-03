package com.jforj.repositorytest.repository;

import com.jforj.repositorytest.annotation.RepositoryAnnotation;
import com.jforj.repositorytest.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// 모든 설정을 커스텀 어노테이션으로 한 개로 대체
@RepositoryAnnotation
class StudentRepositoryTest {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void selectNamesTest() {
        // given
        String givenName = "givenName";
        studentJpaRepository.save(
                StudentEntity
                        .builder()
                        .name(givenName)
                        .age(20)
                        .schoolNo(1L)
                        .build()
        );

        // when
        String filterName =
                studentRepository
                        .selectNames()
                        .stream()
                        .filter(name -> name.equals(givenName))
                        .findFirst()
                        .get();

        // then
        assertNotNull(filterName);
    }
}