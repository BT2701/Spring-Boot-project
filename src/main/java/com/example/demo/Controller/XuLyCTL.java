package com.example.demo.Controller;


import com.example.demo.Model.XuLy;
import org.springframework.stereotype.Controller;

import com.example.demo.service.XuLyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class XuLyCTL {
    
    @Autowired
    private XuLyService xuLyService;
	
        @GetMapping("/admin-xuly")
	public String xuLyViPham(Model model) {
            List<XuLy> list = xuLyService.findAll();
            model.addAttribute("list", list);
            return "admin-xuly";
	}
}
