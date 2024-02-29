package com.serby.eventdriventester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EventDrivenTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenTesterApplication.class, args);
	}

}
