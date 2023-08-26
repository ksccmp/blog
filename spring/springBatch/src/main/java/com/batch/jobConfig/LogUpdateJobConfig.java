package com.batch.jobConfig;

import com.batch.entity.LogEntity;
import com.batch.repository.LogJpaRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LogUpdateJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final LogJpaRepository logJpaRepository;
    private final EntityManagerFactory entityManagerFactory;

    /**
     * 로그 수정을 위한 Job
     *
     * @return 로그 수정 Job
     */
    @Bean
    public Job logUpdateJob() {
        return new JobBuilder("logUpdateJob", jobRepository)
                .start(logUpdateStep()) // job이 처음 시작될 때 실행되는 step
                .preventRestart() // job 실행이 실패할 경우 재시작 막기
                .build();
    }

    /**
     * 로그 수정을 위한 Step
     *
     * @return 로그 수정 Step
     */
    @Bean
    public Step logUpdateStep() {
        return new StepBuilder("logUpdateStep", jobRepository)
                .<LogEntity, LogEntity>chunk(20, transactionManager) // transaction 처리를 20개 단위씩 묶어 처리, Generic은 <reader에서 넘겨주는 객체, writer로 넘겨줄 객체>
                .reader(logUpdateItemReader())
                .processor(logUpdateItemProcessor(null)) // 파라미터 사용하는 곳에 null 넣기
                .writer(logUpdateItemWriter())
                .build();
    }

    /**
     * 로그 수정을 위한 ItemReader (데이터 조회)
     *
     * @return 로그 수정 ItemReader
     */
    @Bean
    public ItemReader<LogEntity> logUpdateItemReader() {
        return new JpaPagingItemReaderBuilder<LogEntity>()
                .name("logRegisterItemReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(10) // 10개 단위로 페이징 처리하며 조회
                .queryString("select l from LogEntity l") // JPQL을 이용하여 수정할 데이터 조회
                .build();
    }

    /**
     * 로그 수정을 위한 ItemProcessor (데이터 수정 작업 처리) (ItemProcessor Generic은 <reader에서 넘겨주는 객체, writer로 넘겨줄 객체>)
     *
     * @return 로그 수정 ItemProcessor
     */
    @Bean
    @StepScope // 파라미터 사용을 위해 StepScope 추가
    public ItemProcessor<LogEntity, LogEntity> logUpdateItemProcessor(@Value("#{jobParameters[contents]}") String contents) {
        // reader에서 넘겨준 객체를 1개 단위로 처리 (한 번에 chunkSize 만큼 수행)
        return logEntity -> {
            logEntity.updateContents(contents); // 파라미터 값을 가져와 활용
            return logEntity;
        };
    }

    /**
     * 로그 수정을 위한 ItemWriter (데이터 쓰기)
     *
     * @return 로그 수정 ItemWriter
     */
    @Bean
    public ItemWriter<LogEntity> logUpdateItemWriter() {
        // processor에서 넘겨준 객체를 chunk 단위로 처리 (한 번에 chunkSize 만큼 수행)
        return logEntities -> {
            for (LogEntity logEntity : logEntities) {
                logJpaRepository.save(logEntity);
            }
        };
    }
}
