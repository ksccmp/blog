package com.querydsl.repository;

import static com.querydsl.entity.QStudent.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.entity.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ConstantRepository {
	
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	
	// 문자열 상수값 예시
	public Student stringContant() {
		return jpaQueryFactory.select(Projections.fields(Student.class,
														 student.no,
														 Expressions.asString("문자열").as("name")))
						      .from(student)
						      .fetchFirst();
	}
	
	// 숫자 상수값 예시
	public Student numberContant() {
		return jpaQueryFactory.select(Projections.fields(Student.class,
														 Expressions.asNumber(0).as("no"),
														 student.name))
							  .from(student)
							  .fetchFirst();
	}
}
