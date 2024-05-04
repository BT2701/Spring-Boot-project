package com.example.demo.Controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.XuLy;

@Controller
public class XuLyCTL {
	@GetMapping("/xu-ly-vi-pham")
	public String xuLyViPham() {
		return "admin-xuly";
	}
}
