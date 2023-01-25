package com.querydsl.oneequalone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school")
public class SchoolEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  private int no;
    private String name;
    private String address;
}
