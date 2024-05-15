package com.jforj.redistemplate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
    private final RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration(
                        redisProperties.getHost(),
                        redisProperties.getPort()
                )
        );
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        // redis template에 connection factory 연결
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // key에 대한 직렬화 방법 등록
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value에 대한 직렬화 방법 등록
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        // hash key에 대한 직렬화 방법 등록
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash value에 대한 직렬화 방법 등록
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
