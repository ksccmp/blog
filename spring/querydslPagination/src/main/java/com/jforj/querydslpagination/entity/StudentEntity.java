package com.jforj.querydslpagination.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String name;
    private int age;
    private String createId;
    private LocalDateTime createAt;
    private String updateId;
    private LocalDateTime updateAt;

    @Builder
    public StudentEntity(String name, int age, String createId, String updateId) {
        this.name = name;
        this.age = age;
        this.createId = createId;
        this.createAt = LocalDateTime.now();
        this.updateId = updateId;
        this.updateAt = LocalDateTime.now();
    }
}
