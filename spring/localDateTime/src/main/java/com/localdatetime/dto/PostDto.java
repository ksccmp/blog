package com.localdatetime.dto;

import com.localdatetime.annotation.LocalDateTimeFormat;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class PostDto {
    @LocalDateTimeFormat
    private LocalDateTime date;
}
