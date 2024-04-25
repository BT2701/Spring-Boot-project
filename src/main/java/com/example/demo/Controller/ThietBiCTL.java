package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Model.ThietBiModel;
import com.example.demo.Model.ThietBiModel;
import com.example.demo.repository.ThietBiRepository;

@Controller
public class ThietBiCTL {
	@Autowired
	private ThietBiRepository thietBiRepository;
	
	@GetMapping("/thietbi")
    public List<ThietBiModel> getAllthietBi() {
        List<ThietBiModel> thietBis = (List<ThietBiModel>) thietBiRepository.findAll();
        thietBis.forEach(thietBi -> {
            System.out.println("ID: " + thietBi.getMaTB() + ", Name: " + thietBi.getTenTB() + ", Age: " + thietBi.getTenTB());
        });
        return thietBis;
    }
}
