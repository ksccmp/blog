package com.lambda.batch.service.impl;

import com.lambda.batch.entity.LambdaLogEntity;
import com.lambda.batch.repository.LambdaLogJpaRepository;
import com.lambda.batch.service.LambdaLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LambdaLogServiceImpl implements LambdaLogService {

    @Autowired
    private LambdaLogJpaRepository lambdaLogJpaRepository;

    @Override
    public List<LambdaLogEntity> register(List<LambdaLogEntity> lambdaLogEntityList) {
        // 저장
        List<LambdaLogEntity> resLambdaLogEntityList = lambdaLogJpaRepository.saveAll(lambdaLogEntityList);

        // 결과 반환
        return resLambdaLogEntityList;
    }
}
