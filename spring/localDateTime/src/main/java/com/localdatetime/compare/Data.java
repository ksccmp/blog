package com.localdatetime.compare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@AllArgsConstructor
public class Data {
    private Date date;
    private LocalDateTime localDateTime;
}
