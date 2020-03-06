package com.kundan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutoWireApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(AutoWireApplication.class, args);
		//System.out.println("hello........");
		
		Kundan kundan=(Kundan) context.getBean(Kundan.class);	
		kundan.show();
		
		
	}

}
