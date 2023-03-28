package com.spring.querydsl.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.querydsl.entity.QStudent;
import com.spring.querydsl.entity.SomeStudent;

@Repository
public class StudentQueryRepository {
	
	@Autowired
	private JPAQueryFactory jpaQueryFacotry;
	
//	Tuple
//	public List<SomeStudent> findForSomeStudentList() {
//		List<Tuple> tupleList = jpaQueryFacotry.select(QStudent.student.name,
//									  				   QStudent.student.age)
//											   .from(QStudent.student)
//											   .fetch();
//		
//		List<SomeStudent> someStudentList = new ArrayList<>();
//		for(Tuple tuple : tupleList) {
//			SomeStudent someStudent = SomeStudent.builder()
//												 .name(tuple.get(QStudent.student.name))
//												 .age(tuple.get(QStudent.student.age))
//												 .build();
//			
//			someStudentList.add(someStudent);
//		}
//		
//		return someStudentList;
//	}
	
//	Projections - field
//	public List<SomeStudent> findForSomeStudentList() {
//		return jpaQueryFacotry.select(Projections.fields(SomeStudent.class,
//														 QStudent.student.name,
//														 QStudent.student.age))
//							  .from(QStudent.student)
//							  .fetch();
//	}
	
//	Projections - constructor
//	public List<SomeStudent> findForSomeStudentList() {
//		return jpaQueryFacotry.select(Projections.constructor(SomeStudent.class,
//														 	  Expressions.asString(QStudent.student.name).as("randomName"),
//														 	  QStudent.student.age))
//							  .from(QStudent.student)
//							  .fetch();
//	}
	
//	Projections - setter
	public List<SomeStudent> findForSomeStudentList() {
		return jpaQueryFacotry.select(Projections.bean(SomeStudent.class,
												 	   QStudent.student.name,
												 	   QStudent.student.age))
							  .from(QStudent.student)
							  .fetch();
	}
}
