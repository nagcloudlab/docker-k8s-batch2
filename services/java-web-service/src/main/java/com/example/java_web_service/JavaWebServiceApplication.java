package com.example.java_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavaWebServiceApplication {

	@GetMapping("/api/info")
	public String getInfo() {
		return "Hello from Java Web Service!";
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaWebServiceApplication.class, args);
	}

}
