package com.example.customvalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_PARAMETER(400, "Bad Invalid Parameter."),
    PAGE_NOT_FOUND(404, "Page not found."),
    INTERNAL_SERVER_ERROR(500, "Server Error..");

    private final int code;
    private final String message;
}
