package com.imp;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.imp.entities")
@EnableJpaRepositories("com.imp.repositories")
@ComponentScan({"com.imp.entities","com.imp.repositories","com.imp.controllers","com.imp.services","com.imp.enums"})

public class ImpApplicationTests {

	

}
