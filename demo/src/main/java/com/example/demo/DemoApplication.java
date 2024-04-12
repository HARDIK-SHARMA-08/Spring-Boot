package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Run the Spring Boot application and get the application context
		var ctx = SpringApplication.run(DemoApplication.class, args);

		// Retrieve a bean of type MyFirstClass from the application context
		MyFirstService firstService = ctx.getBean(MyFirstService.class);

		// Call the helloWorld() method of MyFirstClass and print the result
		System.out.println(firstService.tellStory());
		System.out.println(firstService.JAVAversion());
		System.out.println(firstService.OSdetails());
		System.out.println(firstService.getCustomProperty());
		System.out.println(firstService.getCustomPropertyFromAnotherFile());
		System.out.println(firstService.getCustom2PropertyFromAnotherFile());
		System.out.println(firstService.getApplicationProperty());
	}
}
