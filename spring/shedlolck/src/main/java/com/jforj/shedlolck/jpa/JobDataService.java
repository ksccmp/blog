package com.jforj.shedlolck.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class JobDataService {
    private final JobDataJpaRepository jobDataJpaRepository;

    public void insert() {
        jobDataJpaRepository.save(
                JobDataEntity
                        .builder()
                        .name(UUID.randomUUID().toString())
                        .build()
        );
    }
}
