package com.kundan.demo;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MyWebAppProjectApplicationTests {


	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private HelloController template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.index(),
                String.class);
        assertThat(response.getBody().equals("Greetings from Spring Boot!"));
    }
}
