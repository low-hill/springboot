package com.example.customvalidation.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GenderCode {
    MALE("1001", "MALE"),
    FEMALE("1002", "FEMALE");

    private String code;
    private String name;
}
