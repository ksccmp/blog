package com.localdatetime.compare;

import java.time.LocalDateTime;
import java.util.Date;

public class Compare {
    public static void main(String[] args) {
        Data data = new Data(new Date(), LocalDateTime.now());

        Date newDate = data.getDate();
        LocalDateTime newLocalDateTime = data.getLocalDateTime();

        newDate.setTime(1695476838988L); // 특정 시간대로 변경
        newLocalDateTime = newLocalDateTime.plusDays(3); // 3일 후로 변경

        System.out.println(data.getDate()); // Sat Sep 23 22:47:18 KST 2023
        System.out.println(newDate); // Sat Sep 23 22:47:18 KST 2023 (원본과 동일)
        System.out.println(data.getLocalDateTime()); // 2023-09-23T22:55:02.129660700
        System.out.println(newLocalDateTime); // 2023-09-26T22:55:02.129660700 (원본과 다름)
    }
}
