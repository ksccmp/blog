package com.jforj.sse.controller;

import com.jforj.sse.dto.SseSendRequest;
import com.jforj.sse.service.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class SseController {
    private final SseService sseService;

    @GetMapping("/subscribe/{id}")
    public SseEmitter subscribe(@PathVariable String id) {
        return sseService.subscribe(id);
    }

    @PostMapping("/send/{id}")
    public void sendAlarm(@PathVariable String id, @RequestBody SseSendRequest sseSendRequest) {
        sseService.sendToClient(id, sseSendRequest.eventName(), sseSendRequest.data());
    }
}
