package com.asscache.asscache;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableRabbit
@SpringBootApplication
public class AsscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsscacheApplication.class, args);
	}

}
