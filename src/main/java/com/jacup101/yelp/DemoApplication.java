package com.jacup101.yelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
// API -> endpoints that you create to access the database
// path, paramater -> set via http request (GET, POST, DELETE)
// results are sent back in a json format
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String helloYou() {
		return "Hello, Celia";
	}

}
