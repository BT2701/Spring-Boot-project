package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.View.HomePage.HomePage;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String homepage() {
		return "home";
	}
}
