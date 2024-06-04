package com.jforj.querydslpagination.repository;

import com.jforj.querydslpagination.dto.PagingStudent;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jforj.querydslpagination.entity.QStudentEntity.studentEntity;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public Page<PagingStudent> getStudents(Pageable pageable) {
        List<PagingStudent> pagingStudents =
                jpaQueryFactory
                        .select(
                                Projections.constructor(
                                        PagingStudent.class,
                                        studentEntity.name,
                                        studentEntity.age
                                )
                        )
                        .from(studentEntity)
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .fetch();

        JPAQuery<Long> pagingStudentsCountQuery =
                jpaQueryFactory
                        .select(studentEntity.count())
                        .from(studentEntity);

        return PageableExecutionUtils
                .getPage(
                        pagingStudents,
                        pageable,
                        pagingStudentsCountQuery::fetchOne
                );
    }
}
