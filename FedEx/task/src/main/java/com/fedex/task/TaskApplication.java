package com.fedex.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		System.out.println("in main(), before running SP app");
		SpringApplication.run(TaskApplication.class, args);
		System.out.println("Application is ready.");
	}

}
