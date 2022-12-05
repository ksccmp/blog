package com.lambda.batch.consumer;

import com.lambda.batch.entity.LambdaLogEntity;
import com.lambda.batch.service.LambdaLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
@Slf4j
public class LambdaLogConsumer implements Consumer<Object> {

    @Autowired
    private LambdaLogService lambdaLogService;

    @Override
    public void accept(Object o) {
        List<LambdaLogEntity> lambdalLogEntityList = Arrays.asList(
                new LambdaLogEntity(0, o.toString(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                new LambdaLogEntity(0, "yyyyMMddHHmmss pattern", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                new LambdaLogEntity(0, "yyyyMMdd pattern", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        );

        List<LambdaLogEntity> resLambdaLogEntityList = lambdaLogService.register(lambdalLogEntityList);
        if(resLambdaLogEntityList != null) {
            log.info("저장된 데이터 갯수 : " + resLambdaLogEntityList.size() + " 개");
        }
    }
}
