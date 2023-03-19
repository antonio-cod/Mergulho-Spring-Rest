package com.algaworks.algalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AulaSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AulaSpringApplication.class, args);
	}

}
