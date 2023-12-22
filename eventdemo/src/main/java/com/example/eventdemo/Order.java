package com.example.eventdemo;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Order {
    private String orderId;

    private double price;

    private String method;
}
