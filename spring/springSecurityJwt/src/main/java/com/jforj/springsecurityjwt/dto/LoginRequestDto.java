package com.jforj.springsecurityjwt.dto;

public record LoginRequestDto(
        String userId,
        String password
) {
}
