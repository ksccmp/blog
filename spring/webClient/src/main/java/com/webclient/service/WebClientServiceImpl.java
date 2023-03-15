package com.webclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WebClientServiceImpl {

    public void get() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        // api 요청
        Map<String, Object> response =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        // 결과 확인
        log.info(response.toString());
    }

    public void getEntity() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        // api 요청
        ResponseEntity<Map> response =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .toEntity(Map.class)
                        .block();

        // 결과 확인
        log.info(response.toString());
    }

    public void getFlux() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        // api 요청
        List<String> response =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToFlux(Map.class)
                        .toStream()
                        .map(map -> map.toString())
                        .collect(Collectors.toList());

        // 결과 확인
        log.info(response.toString());
    }

    public void getMultiple() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        // api 요청 - 1
        Mono<Map> responseMono1 =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToMono(Map.class);

        // api 요청 - 2
        Mono<Map> responseMono2 =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("/api/get")
                                        .queryParam("code", code)
                                        .build())
                        .retrieve()
                        .bodyToMono(Map.class);

        // multiple api 요청
        Map<String, Object> response =
                Mono
                        .zip(responseMono1, responseMono2, (response1, response2) -> {
                            Map<String, Object> map = new HashMap<>();
                            map.put("response1", response1);
                            map.put("response2", response2);

                            return map;
                        })
                        .block();

        // 결과 확인
        log.info(response.toString());
    }

    public void post() {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", "j4j");
        bodyMap.put("age", 123);

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        // api 요청
        Map<String, Object> response =
                webClient
                        .post()
                        .uri("/api/post")
                        .bodyValue(bodyMap)
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

        // 결과 확인
        log.info(response.toString());
    }

    public void defaultValue() {
        String code = "myCode";

        // webClient 기본 설정
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:8080")
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .defaultCookie("cookie", "cookieValue")
                        .build();

        // api 요청 - 1
        webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/get")
                                .queryParam("code", code)
                                .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        // api 요청 - 2
        webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/get")
                                .queryParam("code", code)
                                .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
