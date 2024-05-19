package com.jforj.shedlolck.jpa;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "job_data")
public class JobDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String name;

    @Builder
    public JobDataEntity(String name) {
        this.name = name;
    }
}
