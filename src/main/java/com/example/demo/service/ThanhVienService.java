package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;

@Service
public class ThanhVienService {
	private final ThanhVienRepository thanhVienRepository;
	
	@Autowired
	public ThanhVienService(ThanhVienRepository thanhVienRepository) {
		this.thanhVienRepository=thanhVienRepository;
	}
	public ThanhVien addMember(ThanhVien mem) {
		return thanhVienRepository.save(mem);
	}
	
}
