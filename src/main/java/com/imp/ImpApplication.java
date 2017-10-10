package com.imp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "entities")
@EnableJpaRepositories("repositories")
@ComponentScan({"entities","repositories","controllers"})
@SpringBootApplication
public class ImpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpApplication.class, args);
	}
}
