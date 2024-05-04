package com.jforj.threadlocal.service;

import com.jforj.threadlocal.dto.User;
import com.jforj.threadlocal.threadlocal.UserThreadLocal;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadLocalService {
    public void getName(String id) {
        // 3개 thread로 동시에 비즈니스 로직 처리
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int index = i + 1;
            executorService.submit(() -> {
                // 이전 thread 처리 정보 확인
                User prevUser = UserThreadLocal.getInstance().get();
                if (prevUser != null) {
                    System.out.println("you already have user info");
                    return;
                }

                // 전 처리
                preHandle(index, id);

                // thread local에서 사용자 정보 조회
                User user = UserThreadLocal.getInstance().get();
                System.out.println("user index is " + user.index());
                System.out.println("user name is " + user.name());

                // 후 처리
                postHandle();
            });
        }

        executorService.shutdown();
    }

    private void preHandle(int index, String id) {
        String name = null;
        switch (id) {
            case "1234": {
                name = "abcd";
                break;
            }
        }

        // thread local에 사용자 정보 저장
        UserThreadLocal.getInstance()
                .set(
                        User
                                .builder()
                                .index(index)
                                .id(id)
                                .name(name)
                                .build()
                );
    }

    private void postHandle() {
        UserThreadLocal.getInstance().remove();
    }
}
