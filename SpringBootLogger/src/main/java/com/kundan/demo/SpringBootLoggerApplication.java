package com.kundan.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLoggerApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(SpringBootLoggerApplication.class);
	
	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		LOGGER.debug("Request {}",name);
		String responce="Hi"+ name + "Welcome";
		LOGGER.debug("Responce {}",responce);
		return responce;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggerApplication.class, args);
		
		LOGGER.info("Simple log statement with inputs {}, {} and {}\", 1,2,3");
		
		
	}

}
