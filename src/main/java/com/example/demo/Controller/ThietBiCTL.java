package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ThietBiCTL {

	@GetMapping("/thietbi")
    public String getAllthietBi() {
        
        return "thiết bị";
    }
}
