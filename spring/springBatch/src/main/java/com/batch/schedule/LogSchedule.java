package com.batch.schedule;

import com.batch.jobConfig.LogRegisterJobConfig;
import com.batch.jobConfig.LogUpdateJobConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class LogSchedule {

    private final JobLauncher jobLauncher;
    private final LogRegisterJobConfig logRegisterJobConfig;
    private final LogUpdateJobConfig logUpdateJobConfig;

    @Scheduled(cron = "0/10 * * * * ?") // 10초마다 Job 실행, cron 표현식 활용 (초 분 시 일 월 요일)
    public void logRegister() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(
                logRegisterJobConfig.logRegisterJob(),
                new JobParametersBuilder()
                        .addLong("time", new Date().getTime()) // parameter를 매번 달리하여 동일한 job이어도 스케줄 설정에 맞게 반복되어 실행되도록 설정
                        .toJobParameters()
        );
    }

    @Scheduled(fixedRate = 20000) // 메서드가 실행된 시간부터 20초마다 Job 실행
    public void logUpdate() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(
                logUpdateJobConfig.logUpdateJob(),
                new JobParametersBuilder()
                        .addLong("time", new Date().getTime()) // parameter를 매번 달리하여 동일한 job이어도 스케줄 설정에 맞게 반복되어 실행되도록 설정
                        .toJobParameters()
        );
    }
}
