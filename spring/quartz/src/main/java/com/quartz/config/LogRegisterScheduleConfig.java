package com.quartz.config;

import com.quartz.job.LogRegisterJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LogRegisterScheduleConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public void start() throws SchedulerException {
        // Job에서 Bean을 가져와 사용하기 위해 활용
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("applicationContext", applicationContext);

        // Job을 이용하여 JobDetail을 생성
        JobDetail jobDetail =
                JobBuilder
                        .newJob(LogRegisterJob.class) // 실행될 Job
                        .setJobData(jobDataMap) // Job에서 활용될 jobDataMap 등록
                        .withIdentity("LogRegisterJobDetailName", "LogRegisterJobDetailGroup") // 식별을 위한 Identity 등록 (name, group)
                        .build();

        // 스케줄링을 위한 Trigger 등록
        Trigger trigger =
                TriggerBuilder
                        .newTrigger()
                        .withIdentity("LogRegisterTriggerName", "LogRegisterTriggerGroup") // 식별을 위한 Identity 등록 (name, group)
                        .startNow() // 실행과 동시에 스케줄링 시작
                        // 5초 간격으로 무한히 스케줄링 처리
                        .withSchedule(
                                SimpleScheduleBuilder
                                        .simpleSchedule()
                                        .withIntervalInSeconds(5)
                                        .repeatForever()
                        )
                        .build();

        // Scheduler로 Job과 Trigger 관리
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
