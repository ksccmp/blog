package com.jforj.querydslpagination.repository;

import com.jforj.querydslpagination.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
