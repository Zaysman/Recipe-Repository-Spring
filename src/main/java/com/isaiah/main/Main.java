package com.isaiah.main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;


//import com.example.reciperepositoryspring.ReciperepositoryspringApplication;

import lombok.extern.java.Log;

@SpringBootApplication

@Log //Log from Lombok dependency.
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
		
		
		log.info("Launching Spring Boot Application from Main.java.");
		
		
		
//		log.info("closing app.");
//		System.exit(0);	
	}
	
	

}
