package com.jforj.querydsl.repository;

import com.jforj.querydsl.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
