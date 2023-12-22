package com.example.eventdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventdemoApplication.class, args);
	}

}
