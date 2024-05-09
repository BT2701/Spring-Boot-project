package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String login() {
		return "login-signup/login";
	}
	@GetMapping("/sign-up")
	public String sigup() {
		return "login-signup/register";
	}
	@GetMapping("/forgot-password")
	public String forgotPass(){
		return "login-signup/resetpasword";
	}
	@GetMapping("/admin-header")
	public String header_admin(){
		return "header-footer/admin-header";
	}
	@GetMapping("/user-header")
	public String header_user(){
		return "header-footer/user-header";
	}
	@GetMapping("/footer")
	public String footer(){
		return "header-footer/footer";
	}
	@GetMapping("/home")
	public String home() {
		return "slider/slider";
	}
}
