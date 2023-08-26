package com.batch.jobConfig;

import com.batch.entity.LogEntity;
import com.batch.repository.LogJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class LogRegisterJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final LogJpaRepository logJpaRepository;

    /**
     * 로그 등록을 위한 Job
     *
     * @return 로그 등록 Job
     */
    @Bean
    public Job logRegisterJob() {
        return new JobBuilder("logRegisterJob", jobRepository)
                .start(contentsLogRegisterStep()) // job이 처음 시작될 때 실행되는 step
                .next(dateLogRegisterStep()) // 이전 step이 끝나면 실행되는 step
                .preventRestart() // job 실행이 실패할 경우 재시작 막기
                .build();
    }

    /**
     * contents가 입력된 로그 등록을 위한 Step
     *
     * @return contents 입력 로그 등록 Step
     */
    @Bean
    public Step contentsLogRegisterStep() {
        return new StepBuilder("contentsLogRegisterStep", jobRepository)
                .tasklet(contentsLogRegisterTasklet(), transactionManager) // step에서 실행될 tasklet
                .build();
    }

    /**
     * contents가 입력된 로그 등록을 위한 Tasklet
     *
     * @return contents 입력 로그 등록 Tasklet
     */
    @Bean
    public Tasklet contentsLogRegisterTasklet() {
        return (contribution, chunkContext) -> {
            // StepContext에서 JobParameter 가져오기
            Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();

            // 로그 데이터 적재
            logJpaRepository.save(
                    LogEntity
                            .builder()
                            .contents(jobParameters.get("contents").toString()) // 파라미터에서 전달받은 값으로 변경
                            .build()
            );

            // 배치 종료
            return RepeatStatus.FINISHED;
        };
    }

    /**
     * date가 입력된 로그 등록을 위한 Step
     *
     * @return date 입력 로그 등록 Step
     */
    @Bean
    public Step dateLogRegisterStep() {
        return new StepBuilder("dateLogRegisterStep", jobRepository)
                .tasklet(dateLogRegisterTasklet(), transactionManager) // step에서 실행될 tasklet
                .build();
    }

    /**
     * date가 입력된 로그 등록을 위한 Tasklet
     *
     * @return date 입력 로그 등록 Tasklet
     */
    @Bean
    public Tasklet dateLogRegisterTasklet() {
        return (contribution, chunkContext) -> {
            // 로그 데이터 적재
            logJpaRepository.save(
                    LogEntity
                            .builder()
                            .createAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .updateAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build()
            );

            // 랜덤값이 조건을 넘는 경우 배치 종료
            if (Math.random() * 10 >= 8) {
                return RepeatStatus.FINISHED;
            }

            // 랜덤값이 조건을 넘지 않는 경우 tasklet 처리 반복
            return RepeatStatus.CONTINUABLE;
        };
    }
}