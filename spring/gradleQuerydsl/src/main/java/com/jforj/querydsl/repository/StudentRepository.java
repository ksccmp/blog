package com.jforj.querydsl.repository;

import com.jforj.querydsl.dto.StudentInfoDto;
import com.jforj.querydsl.entity.StudentEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jforj.querydsl.entity.QStudentEntity.studentEntity;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final StudentJpaRepository studentJpaRepository;

    public void createStudent(String name, int age) {
        studentJpaRepository
                .save(
                        StudentEntity
                                .builder()
                                .name(name)
                                .age(age)
                                .createId("createId")
                                .updateId("updateId")
                                .build()
                );
    }

    public List<StudentInfoDto> selectStudentInfo() {
        return jpaQueryFactory
                .select(
                        Projections
                                .fields(
                                        StudentInfoDto.class,
                                        studentEntity.name,
                                        studentEntity.age
                                )
                )
                .from(studentEntity)
                .fetch();
    }
}
