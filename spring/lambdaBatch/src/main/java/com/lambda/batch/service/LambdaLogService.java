package com.lambda.batch.service;

import com.lambda.batch.entity.LambdaLogEntity;

import java.util.List;

public interface LambdaLogService {

    public List<LambdaLogEntity> register(List<LambdaLogEntity> lambdaLogEntityList);
}
