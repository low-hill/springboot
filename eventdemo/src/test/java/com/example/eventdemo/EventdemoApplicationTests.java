package com.example.eventdemo;

import com.github.f4b6a3.ulid.UlidCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class EventdemoApplicationTests {
	@Autowired
	private ApplicationEventPublisher publisher;

	@Test
	void contextLoads() {
	}

	@Test
	void orderEvent() throws Exception {
		Order order = Order.builder()
				.orderId(UlidCreator.getUlid().toString())
				.price(100000)
				.method("CREDIT")
				.build();

		publisher.publishEvent(new OrderEvent(order));
	}

	@Test
	void orderUserEvent() throws Exception {
		Order order = Order.builder()
				.orderId(UlidCreator.getUlid().toString())
				.price(100000)
				.method("CREDIT")
				.build();

		User user = User.builder()
				.id(1000L)
				.loginStatus("1")
				.build();

		OrderEvent orderEvent = new OrderEvent(order);
		UserEvent userEvent = new UserEvent(user);

		System.out.println(System.currentTimeMillis() + "ORDER START");
		publisher.publishEvent(orderEvent);
		System.out.println(System.currentTimeMillis() + "USER START");
		publisher.publishEvent(userEvent);
		System.out.println(System.currentTimeMillis() + " END");
	}
}
