package com.isaiah.main;

import com.isaiah.main.services.*;
import com.isaiah.main.objects.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;


//import com.example.reciperepositoryspring.ReciperepositoryspringApplication;

import lombok.extern.java.Log;

@SpringBootApplication
//@ComponentScan(basePackages = "com.isaiah")
//@SpringBootApplication(scanBasePackages = "com.isaiah")
@Log //Log from Lombok dependency.
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
		
		
		log.info("Launching Spring Boot Application from Main.java.");
		
		
		User user = new User();
		user.setUsername("test4");
		user.setPassword("testpassword");
		user.setEmail("test4@example.com");
		
		UserService userService = context.getBean(UserService.class);
		userService.createUser(user);
		
		
		log.info("closing app.");
		System.exit(0);	
	}
	
	

}
