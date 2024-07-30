package com.example.demo.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WebhookPayload {
    private String id;
    private String payload;
    private String status;
}
