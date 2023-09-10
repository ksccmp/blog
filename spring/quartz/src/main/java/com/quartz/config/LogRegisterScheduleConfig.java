package com.quartz.config;

import com.quartz.job.LogRegisterJob;
import com.quartz.jobfactory.AutowiringSpringBeanJobFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Trigger;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class LogRegisterScheduleConfig {

    private final ApplicationContext applicationContext;

    /**
     * 스케줄링 설정
     *
     * @return 스케줄러 Bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // schedulerFactoryBean으로 변경하여 설정
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        // @Autowired 사용을 위한 설정
        AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory = new AutowiringSpringBeanJobFactory();
        autowiringSpringBeanJobFactory.setApplicationContext(applicationContext);
        schedulerFactoryBean.setJobFactory(autowiringSpringBeanJobFactory);

        // quartz scheduling 관련 설정
        schedulerFactoryBean.setQuartzProperties(properties());

        // 스케줄링을 위한 Trigger 등록
        schedulerFactoryBean.setTriggers(new Trigger[]{simpleTriggerFactoryBean().getObject()});

        return schedulerFactoryBean;
    }

    /**
     * JobDetail 설정
     *
     * @return JobDetail Bean
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        // 실행될 Job
        jobDetailFactoryBean.setJobClass(LogRegisterJob.class);
        // 식별을 위한 Identity 등록 (group)
        jobDetailFactoryBean.setGroup("LogRegisterJobDetailGroup");
        // 식별을 위한 Identity 등록 (name)
        jobDetailFactoryBean.setName("LogRegisterJobDetailName");
        return jobDetailFactoryBean;
    }

    /**
     * Trigger 설정
     *
     * @return Trigger Bean
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        // 5초 간격으로 스케줄링 처리
        simpleTriggerFactoryBean.setRepeatInterval(5000);
        // 식별을 위한 Identity 등록 (group)
        simpleTriggerFactoryBean.setGroup("LogRegisterTriggerGroup");
        // 식별을 위한 Identity 등록 (name)
        simpleTriggerFactoryBean.setName("LogRegisterTriggerName");
        return simpleTriggerFactoryBean;
    }

    /**
     * 스케줄링 Properties 설정
     *
     * @return Properties
     */
    @Bean
    public Properties properties() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        // quartz.properties 연결하기
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        Properties properties = null;

        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            log.info("quartzProperties set error");
        }

        return properties;
    }
}
