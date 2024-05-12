package com.jforj.redisrepository.repository;

import com.jforj.redisrepository.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    /**
     * name을 이용하여 user 조회
     */
    User findByName(String name);
}
