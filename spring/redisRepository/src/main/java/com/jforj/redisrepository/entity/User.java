package com.jforj.redisrepository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("user") // hash 기반의 key-value를 구성하여 데이터 저장
@Builder
@Getter
@ToString
public class User {
    @Id // 객체를 식별하기 위해 사용되는 key 값
    private String id;
    @Indexed // 인덱싱 처리
    private String name;
    @TimeToLive // TTL 설정
    private Long expiration;
}
