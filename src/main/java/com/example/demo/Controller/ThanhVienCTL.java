package com.example.demo.Controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.Model.ThanhVienModel;
import com.example.demo.repository.ThanhVienRepository;

@Controller
public class ThanhVienCTL {
	
	@Autowired
	private ThanhVienRepository thanhVienRepository;
	
	@GetMapping("/thanhvien")
    public List<ThanhVienModel> getAllThanhVien() {
        List<ThanhVienModel> thanhViens = (List<ThanhVienModel>) thanhVienRepository.findAll();
        thanhViens.forEach(thanhVien -> {
            System.out.println("ID: " + thanhVien.getMaTV() + ", Name: " + thanhVien.getHoTen() + ", Age: " + thanhVien.getEmail());
        });
        return thanhViens;
    }
}
