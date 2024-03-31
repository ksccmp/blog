package com.jforj.singleton.billpugh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0; i<5; i++) {
            executor.submit(() -> {
                printSingleton();
            });
        }

        // 스레드 풀 종료
        executor.shutdown();
    }

    public static void printSingleton() {
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        billPughSingleton.print();
    }
}
