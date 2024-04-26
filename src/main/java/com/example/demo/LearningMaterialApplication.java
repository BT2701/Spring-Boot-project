package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.example.demo.Model.*;
//import com.example.demo.View.HomePage.HomePage;
//import com.example.demo.repository.*;
//import com.example.demo.Controller.*;

@SpringBootApplication
@ComponentScan(basePackages = "Controller")
@EntityScan(basePackages ="Model")
@EnableJpaRepositories(basePackages ="repository")
public class LearningMaterialApplication {

	public static void main(String[] args) {
//		new HomePage("Nguyễn Văn A");
		SpringApplication.run(LearningMaterialApplication.class, args);
	}

}
