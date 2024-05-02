package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
//@ComponentScan(basePackages = "Controller")
//@EnableJpaRepositories(basePackages = "repository")
//@EntityScan(basePackages = "Model")
public class LearningMaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningMaterialApplication.class, args);

	}

}
