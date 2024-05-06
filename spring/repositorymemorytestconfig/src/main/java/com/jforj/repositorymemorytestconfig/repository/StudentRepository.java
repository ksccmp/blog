package com.jforj.repositorymemorytestconfig.repository;

import com.jforj.repositorymemorytestconfig.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final StudentJpaRepository studentJpaRepository;

    public List<String> insertAndSelectNames(String name, int age, long schoolNo) {
        if (StringUtils.hasText(name)) {
            StudentEntity studentEntity =
                    StudentEntity
                            .builder()
                            .name(name)
                            .age(age)
                            .schoolNo(schoolNo)
                            .build();
            studentJpaRepository.save(studentEntity);
        }

        List<StudentEntity> studentEntities = studentJpaRepository.findAll();
        return studentEntities.stream().map(StudentEntity::getName).collect(Collectors.toList());
    }
}
