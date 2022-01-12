package com.example.PizzaManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PizzaManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaManagementSystemApplication.class, args);
	}

}
