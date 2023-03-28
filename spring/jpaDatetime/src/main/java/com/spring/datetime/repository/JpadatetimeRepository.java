package com.spring.datetime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.datetime.entity.Jpadatetime;

public interface JpadatetimeRepository extends JpaRepository<Jpadatetime, Integer> {

}
