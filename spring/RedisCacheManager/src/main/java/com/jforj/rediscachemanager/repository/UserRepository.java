package com.jforj.rediscachemanager.repository;

import com.jforj.rediscachemanager.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;

    public User create(String id, String name) {
        return createCache(id, name);
    }

    @CachePut(value = "user", key = "#id")
    public User createCache(String id, String name) {
        User user = User.builder()
                .id(id)
                .name(name)
                .build();

        return userJpaRepository.save(user);
    }

    @Cacheable(value = "user")
    public List<User> selectAll() {
        return userJpaRepository.findAll();
    }

    @CacheEvict(value = "user", key = "#id")
    public void delete(String id) {
        userJpaRepository.deleteById(id);
    }
}
