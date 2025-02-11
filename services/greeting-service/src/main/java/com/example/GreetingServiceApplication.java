package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// line-1
// line-2
// line-3
// line-4
// line-5
// line-6
// line-7

@SpringBootApplication
@RestController
public class GreetingServiceApplication {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, from greeting-service";
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
