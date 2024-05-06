package com.jforj.repositorymemorytestconfig.repository;

import com.jforj.repositorymemorytestconfig.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
