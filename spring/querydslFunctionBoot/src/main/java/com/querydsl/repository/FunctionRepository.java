package com.querydsl.repository;

import static com.querydsl.entity.QStudent.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.entity.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class FunctionRepository {
	
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	
	public List<Student> function() {
		return jpaQueryFactory.select(Projections.fields(Student.class,
														 student.no,
														 Expressions.stringTemplate("get_function_test({0}, {1})",
																					student.name,
																					student.age)
														 			.as("name")))
						      .from(student)
						      .fetch();
	}
}
