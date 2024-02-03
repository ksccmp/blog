package com.jforj.repositorytest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private long schoolNo;

    @Builder
    public StudentEntity(String name, int age, long schoolNo) {
        this.name = name;
        this.age = age;
        this.schoolNo = schoolNo;
    }
}
