package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;

@Controller
public class ThanhVienCTL {
	@Autowired
	private ThanhVienRepository thanhVienRepository;
	
	@GetMapping("/thanh-vien")
    public String getAllThanhVien(Model m) {
		Iterable<ThanhVien>list= thanhVienRepository.findAll();
		m.addAttribute("data", list);
        return "thanhvien";
    }
}
