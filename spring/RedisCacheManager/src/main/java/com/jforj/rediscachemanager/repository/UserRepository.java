package com.jforj.redistemplate.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jforj.redistemplate.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public void create(String id, String name, Long expiration) {
        User user = User.builder()
                .id(id)
                .name(name)
                .build();

        setRedis(id, user);
        redisTemplate.expire(id, Duration.ofSeconds(expiration));
    }

    public void selectAll() {
        List<String> keys = new ArrayList<>(redisTemplate.keys("*"));
        List<User> users = getRedisValue(keys, User.class);

        System.out.println(users);
    }

    /**
     * value 값을 직렬화하여 redis에 저장
     */
    private void setRedis(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 직렬화되어 저장된 value 값을 redis에서 조회 후 class type에 맞게 변환
     */
    private <T> T getRedisValue(String key, Class<T> valueClass) {
        String value = redisTemplate.opsForValue().get(key);
        if (!StringUtils.hasText(value)) {
            return null;
        }

        try {
            return objectMapper.readValue(value, valueClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 직렬화되어 저장된 value 값을 redis에서 조회 후 class type에 맞게 변환
     */
    private <T> List<T> getRedisValue(List<String> keys, Class<T> valueClass) {
        List<String> values = redisTemplate.opsForValue().multiGet(keys);
        if (values.size() < 1) {
            return new ArrayList<>();
        }

        return values
                .stream()
                .map(value -> {
                    try {
                        return objectMapper.readValue(value, valueClass);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
