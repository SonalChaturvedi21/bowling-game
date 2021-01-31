package com.bowlinggame.bowlinggame;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.bowlinggame.bowlinggame.controller", "com.bowlinggame.bowlinggame.service", "com.bowlinggame.bowlinggame.parser" })
@EnableJpaRepositories(basePackages = "com.bowlinggame.bowlinggame.repository")
@EntityScan(basePackages = "com.bowlinggame.bowlinggame.model")
public class BowlingGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingGameApplication.class, args);
	}

}
