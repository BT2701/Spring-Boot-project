package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Model.ThanhVienModel;
import com.example.demo.View.HomePage.HomePage;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.Controller")
public class LearningMaterialApplication {

	public static void main(String[] args) {
//		new HomePage("Nguyễn Văn A");
		SpringApplication.run(LearningMaterialApplication.class, args);
	}

}
