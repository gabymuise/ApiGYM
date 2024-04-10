package com.example.GYM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.example.gym")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.gym"})
public class GymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}
}

