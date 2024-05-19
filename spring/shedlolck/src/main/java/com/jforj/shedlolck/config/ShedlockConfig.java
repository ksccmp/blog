package com.jforj.shedlolck.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableSchedulerLock(defaultLockAtLeastFor = "3s", defaultLockAtMostFor = "10s") // default lock 점유 시간 최소 3초, 최대 10초
public class ShedlockConfig {

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(
                JdbcTemplateLockProvider.Configuration
                        .builder()
                        .withJdbcTemplate(new JdbcTemplate((dataSource))) // jdbc datasource 연결
                        .usingDbTime() // DB에 설정되어 있는 서버 시간에 맞춰서 작업
                        .build()
        );
    }
}
