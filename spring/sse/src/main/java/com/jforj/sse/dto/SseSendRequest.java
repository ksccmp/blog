package com.jforj.sse.dto;

public record SseSendRequest(
        String eventName,
        Object data
) {
}
