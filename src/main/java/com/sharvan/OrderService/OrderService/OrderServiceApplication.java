package com.sharvan.OrderService.OrderService;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderServiceApplication {

	public static void main(String[] args) {
		Dotenv dotEnv = Dotenv.configure().load();

		dotEnv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
