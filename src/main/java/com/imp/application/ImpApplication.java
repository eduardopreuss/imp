package com.imp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.imp.entities")
@EnableJpaRepositories("com.imp.repositories")
@ComponentScan({"com.imp.entities","com.imp.repositories","com.imp.controllers"})
@SpringBootApplication
public class ImpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpApplication.class, args);
	}
}
