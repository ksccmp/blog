package com.jforj.repositorytest.repository;

import com.jforj.repositorytest.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
