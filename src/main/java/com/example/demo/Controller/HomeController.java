package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/sig-up")
	public String sigup() {
		return "register";
	}
	@GetMapping("/forgot-password")
	public String forgotPass(){
		return "resetpasword";
	}
	@GetMapping("/admin-header")
	public String header_admin(){
		return "header-footer/admin-header";
	}
	@GetMapping("/footer")
	public String footer(){
		return "header-footer/footer";
	}
}
