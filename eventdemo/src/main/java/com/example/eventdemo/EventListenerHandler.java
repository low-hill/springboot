package com.example.eventdemo;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
public class EventListenerHandler {
    @Async
    @EventListener
    @Order(0)
    public void handleOrder(OrderEvent event) {
        System.out.printf("order listener：%s", event.getOrder().toString()) ;
    }

    @Async
    @EventListener
    @Order(1)
    public void handleUserOrder(OrderEvent event) {
        System.out.printf("user order listener:%s", event.getOrder().toString());
    }

    @Async
    @EventListener
    public void handleUser(UserEvent event) {
        System.out.printf("user listener：%s", event.getUser().toString()) ;
    }
}
