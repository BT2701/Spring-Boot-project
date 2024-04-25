package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ThietBiModel;
import com.example.demo.Model.ThietBiModel;
import com.example.demo.repository.ThietBiRepository;

@RestController
public class ThietBiCTL {
//	@Autowired
//	private ThietBiRepository thietBiRepository;
	
	@GetMapping("/thietbi")
    public String getAllthietBi() {
        
        return "thiết bị";
    }
}
