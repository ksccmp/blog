package com.jforj.repositorytest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jforj.repositorytest.entity.QStudentEntity.studentEntity;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<String> selectNames() {
        return jpaQueryFactory
                .select(studentEntity.name)
                .from(studentEntity)
                .fetch();
    }
}
