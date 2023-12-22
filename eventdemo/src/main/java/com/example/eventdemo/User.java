package com.example.eventdemo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {
    private Long id;

    private String loginStatus;
}
