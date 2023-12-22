package com.example.eventdemo;

import com.github.f4b6a3.ulid.UlidCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public void save(){
        Order order = Order.builder()
                .orderId(UlidCreator.getUlid().toString())
                .price(100000)
                .method("CREDIT")
                .build();
        publisher.publishEvent(new OrderEvent(order));
    }
}
