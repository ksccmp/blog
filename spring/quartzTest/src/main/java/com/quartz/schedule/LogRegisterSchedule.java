package com.batch.quartz.schedule;

import com.batch.quartz.job.LogRegisterJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class LogRegisterSchedule {
    public void start() throws SchedulerException {
        JobDetail jobDetail =
                JobBuilder
                        .newJob(LogRegisterJob.class)
                        .withIdentity("LogRegisterJobDetailName", "LogRegisterJobDetailGroup")
                        .build();

        Trigger trigger =
                TriggerBuilder
                        .newTrigger()
                        .withIdentity("LogRegisterTriggerName", "LogRegisterTriggerGroup")
                        .startNow()
                        .withSchedule(
                                SimpleScheduleBuilder
                                        .simpleSchedule()
                                        .withIntervalInSeconds(10)
                                        .repeatForever()
                        )
                        .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
