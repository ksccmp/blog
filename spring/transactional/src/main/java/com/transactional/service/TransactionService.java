package com.transactional.service;

import com.transactional.entity.LogEntity;
import com.transactional.repository.LogJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final LogJpaRepository logJpaRepository;

    /**
     * 데이터 생성
     */
    public void create() {
        logJpaRepository.save(
                LogEntity
                        .builder()
                        .contents("create")
                        .build()
        );
    }

    /**
     * 데이터 생성 (에러 발생)
     */
    public void createError() {
        logJpaRepository.save(
                LogEntity
                        .builder()
                        .contents("createError")
                        .build()
        );

        throw new RuntimeException("createError");
    }

    /**
     * 모든 contents 데이터를 조회한다.
     *
     * @return 모든 contents 데이터
     */
    @Transactional(readOnly = true)
    public List<String> getContents() {
        return logJpaRepository
                .findAll()
                .stream()
                .map(logEntity -> logEntity.getContents())
                .collect(Collectors.toList());
    }
}
