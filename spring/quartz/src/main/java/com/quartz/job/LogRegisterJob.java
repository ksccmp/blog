package com.quartz.job;

import com.quartz.entity.LogEntity;
import com.quartz.repository.LogJpaRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRegisterJob implements Job {

    /**
     * Job에서 실행될 작업을 정의한다.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Schedule 설정에서 넣어둔 applicationContext를 가져와 Bean 호출에 활용
        ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");
        // Job에서 @Autowired, @RequiredArgsConstructor 등의 주입이 불가하기 때문에 applicationContext 사용
        LogJpaRepository logJpaRepository = applicationContext.getBean(LogJpaRepository.class);

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
