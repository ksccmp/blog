package com.transactional.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionalAop {

    private final PlatformTransactionManager transactionManager;

    @Around("execution(* *..service.*.*(..))") // service 패키지에 있는 모든 메서드에 적용
    public Object serviceTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        // 필요시 @Transactional에서 제공해주는 속성들 설정
        // defaultTransactionDefinition.setReadOnly(true);

        TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            Object object = joinPoint.proceed();
            transactionManager.commit(transactionStatus);
            return object;
        } catch (Throwable e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
    }
}
