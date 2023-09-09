package com.quartz;

import com.quartz.config.LogRegisterScheduleConfig;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(QuartzApplication.class, args);

        new LogRegisterScheduleConfig().start();
    }
}
