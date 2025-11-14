package com.taske.taskDelat;

import jakarta.persistence.Cacheable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TaskDelatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskDelatApplication.class, args);
	}

}
