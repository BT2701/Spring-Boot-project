package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class ThietBiCTL {

	@GetMapping("/thiet-bi-admin")
    public String getAllthietBi() {
        
        return "admin-thietbi/admin-thietbi";
    }
}
