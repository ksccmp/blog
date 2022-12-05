package com.lambda.batch.repository;

import com.lambda.batch.entity.LambdaLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LambdaLogJpaRepository extends JpaRepository<LambdaLogEntity, Long> {

}
