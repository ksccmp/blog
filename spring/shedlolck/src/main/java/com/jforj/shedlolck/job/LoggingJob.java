package com.jforj.shedlolck.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingJob {

    @Scheduled(cron = "0/3 * * * * ?") // 10초마다 task 실행, cron 표현식 활용 (초 분 시 일 월 요일)
    @SchedulerLock(name = "time-logging-lock", lockAtLeastFor = "1s", lockAtMostFor = "5s") // lock 테이블에 저장되는 lock name 설정, lock 점유 시간 최소 1초, 최대 5초
    public void timeLogging() {
        log.info("time logging start");
        log.info("current time is " + new Date().getTime());
        log.info("time logging end");
    }
}
