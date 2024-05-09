package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MuonTraCTL {
	@GetMapping("/DanhSachThietBi")
	public String index() {
		return "user-muontra/user-muontra";
	}
}
