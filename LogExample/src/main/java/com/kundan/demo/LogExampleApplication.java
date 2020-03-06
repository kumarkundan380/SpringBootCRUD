package com.kundan.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LogExampleApplication {
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LogExampleApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(LogExampleApplication.class, args);
		
		 LOGGER.info("Info level log message");
	     LOGGER.debug("Debug level log message");
	     LOGGER.warn("Warning level log message");
	     LOGGER.error("Error level log message");
	}
	@RequestMapping(value = "/hello")
	public String geMessage()
	{
		LOGGER.info("Inside getMessage log file");
		return "Hello World , Kundan ";
	}

}
