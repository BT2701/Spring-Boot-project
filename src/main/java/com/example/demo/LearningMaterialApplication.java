package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.View.HomePage.HomePage;

@SpringBootApplication
public class LearningMaterialApplication {

	public static void main(String[] args) {
		new HomePage("Nguyễn Văn A");
//		SpringApplication.run(LearningMaterialApplication.class, args);
		
	}

}
