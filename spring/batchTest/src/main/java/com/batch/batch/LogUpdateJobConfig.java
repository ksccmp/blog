package com.batch.batch;

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

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LogRegisterJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final LogJpaRepository logJpaRepository;

    @Bean
    public Job logRegisterJob() {
        return new JobBuilder("logRegisterJob", jobRepository)
                .start(logRegisterStep())
                .preventRestart()
                .build();
    }

    @Bean
    public Step logRegisterStep() {
        return new StepBuilder("logRegisterStep", jobRepository)
                .tasklet(logRegisterTasklet(), transactionManager)
                //.<NullType, NullType>chunk(10, transactionManager)
                // .reader(logRegisterItemReader())
                // .processor(logRegisterItemProcessor())
                // .writer(logRegisterItemWriter())
                .build();
    }

    @Bean
    public Tasklet logRegisterTasklet() {
        return (contribution, chunkContext) -> {
            log.info("logRegisterTasklet");

            logJpaRepository.save(
                    LogEntity
                            .builder()
                            .contents("batch contents")
                            .createAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .updateAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build()
            );

            return RepeatStatus.FINISHED;
        };
    }

//    @Bean
//    public ItemReader<LogEntity> logRegisterItemReader() {
//        return new JpaPagingItemReaderBuilder<LogEntity>()
//                .name("logRegisterItemReader")
//                .entityManagerFactory(entityManagerFactory)
//                .pageSize(10)
//                .queryString("select l from LogEntity l")
//                .build();
//    }

//    @Bean
//    public ItemProcessor<NullType, NullType> logRegisterItemProcessor() {
//        return item -> {
//            logJpaRepository.save(
//                    LogEntity
//                            .builder()
//                            .contents("batch contents")
//                            .createAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
//                            .updateAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
//                            .build()
//            );
//
//            return null;
//        };
//    }

//    @Bean
//    public ItemWriter<Log> logRegisterItemWriter() {
//        return logs -> {
//            for (Log rLog : logs) {
//                log.info("rLog= {}", rLog);
//            }
//        };
//    }
}
