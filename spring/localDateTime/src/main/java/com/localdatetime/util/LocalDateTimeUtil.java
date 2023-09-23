package com.localdatetime.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now(); // 2023-09-23T23:09:06.762688200

        // 일 변경
        localDateTime.plusDays(3);
        localDateTime.minusDays(3);

        // 월 변경
        localDateTime.plusMonths(3);
        localDateTime.minusMonths(3);

        // 년 변경
        localDateTime.plusYears(3);
        localDateTime.minusYears(3);

        // 시간 변경
        localDateTime.plusHours(3);
        localDateTime.minusHours(3);

        // 분 변경
        localDateTime.plusMinutes(3);
        localDateTime.minusMinutes(3);

        // 초 변경
        localDateTime.plusSeconds(3);
        localDateTime.minusSeconds(3);

        // 원하는 타입의 값을 조회
        localDateTime.getDayOfMonth(); // 현재 월 중 몇일인지 확인 (ex, 23/09/23이면 23을 반환)
        localDateTime.getDayOfYear(); // 현재 년 중 몇일인지 확인 (ex, 23/09/23이면 266를 반환)
        localDateTime.getDayOfWeek(); // 현재 주차 중 어떤 요일인지 확인 (ex, 23/09/23이면 SATURDAY를 반환)
        localDateTime.getMonthValue(); // 월
        localDateTime.getYear(); // 년
        localDateTime.getHour(); // 시간
        localDateTime.getMinute(); // 분
        localDateTime.getSecond(); // 초

        // 포맷팅
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")); // 2023-09-23 11:08:23
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 2023-09-23
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh,mm,ss")); // 2023.09.23 11,08,23
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss:SSS")); // 2023/09/23 11:08:49:087
    }
}
