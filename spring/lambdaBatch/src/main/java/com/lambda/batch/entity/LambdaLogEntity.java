package com.lambda.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lambda_log")
public class LambdaLogEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long no;
    private String createId;
    private String createAt;
}
