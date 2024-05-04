package com.jforj.threadlocal.dto;

import lombok.Builder;

@Builder
public record User(
        int index,
        String id,
        String name
) {
}
