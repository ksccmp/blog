package com.quartz.repository;

import com.quartz.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJpaRepository extends JpaRepository<LogEntity, Long> {

}
