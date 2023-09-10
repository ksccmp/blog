package com.quartz.job;

import com.quartz.entity.LogEntity;
import com.quartz.repository.LogJpaRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRegisterJob implements Job {

    @Autowired
    private LogJpaRepository logJpaRepository; // requiredArgsConstructor 사용 불가

    /**
     * Job에서 실행될 작업을 정의한다.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 로그 데이터 적재
        logJpaRepository.save(
                LogEntity
                        .builder()
                        .contents("logRegisterJobContents")
                        .createAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .updateAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build()
        );
    }
}
