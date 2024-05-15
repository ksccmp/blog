package com.jforj.redistemplate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
    private String id;
    private String name;
}
