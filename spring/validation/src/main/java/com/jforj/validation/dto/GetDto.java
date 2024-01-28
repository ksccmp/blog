package com.jforj.validation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record GetDto(
        @NotBlank // null, 빈 문자열, 공백으로만 이루어진 문자열이 들어오는 경우 exception 발생
        String name,

        @Min(10) // 10보다 작은 값이 들어오는 경우 exception 발생
        Long age
) {
}
