package com.kundan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringSecurityprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityprojectApplication.class, args);
	}

}
