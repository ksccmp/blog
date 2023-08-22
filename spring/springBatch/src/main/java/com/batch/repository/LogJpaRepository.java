package com.batch.repository;

import com.batch.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJpaRepository extends JpaRepository<LogEntity, Long> {

}
