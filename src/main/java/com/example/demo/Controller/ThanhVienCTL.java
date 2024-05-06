package com.example.demo.Controller;


import com.example.demo.Model.ThietBi;
import com.example.demo.repository.ThietBiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;

import java.util.Optional;

@Controller
public class ThanhVienCTL {
	@Autowired
	private ThanhVienRepository thanhVienRepository;
	@Autowired
	private ThietBiRepository thietBiRepository;
	
	@GetMapping("/thanh-vien-admin")
    public String getAllThanhVien(Model m, @RequestParam(value = "keyword", required = false) String keyword) {
		Iterable<ThanhVien> tvList;
		Iterable<ThietBi> tbList= thietBiRepository.findAll();

		if (keyword != null && !keyword.isEmpty()) {
			// tim kiem theo ten
			tvList = thanhVienRepository.findByHotenContaining(keyword);
		} else {
			tvList = thanhVienRepository.findAll();
		}

		m.addAttribute("tvList", tvList);
		m.addAttribute("tbList", tbList);

        return "admin-thanhvien/admin-thanhvien";
    }
	@GetMapping("/thanhvien/delete/{id}")
	public String deleteThanhVien(@PathVariable Integer id) {
		ThanhVien tv = thanhVienRepository.findById(id).orElse(null);

		if(tv != null) {
			thanhVienRepository.deleteById(id);
		};

		return "redirect:/thanh-vien-admin";
	};

	@PostMapping("/thanhvien/add")
	public String addThanhVien(
			@RequestParam("maTV") Integer maTV,
			@RequestParam("hoten") String hoten,
			@RequestParam("khoa") String khoa,
			@RequestParam("nganh") String nganh,
			@RequestParam("sdt") String sdt,
			@RequestParam("email") String email,
			@RequestParam("password") String password
	) {
		ThanhVien thanhVien = new ThanhVien(maTV, hoten, khoa, nganh, sdt, email, password);
        thanhVienRepository.save(thanhVien);

        return "redirect:/thanh-vien-admin";
    };
	
	@GetMapping("/profile")
    public String profile(Model m) {
		Iterable<ThanhVien>list= thanhVienRepository.findAll();
		m.addAttribute("data", list);
        return "user-profile/user-profile";
    }
	@GetMapping("/profile/editProfile")
    public String editProfile(Model m) {
		Iterable<ThanhVien>list= thanhVienRepository.findAll();
		m.addAttribute("data", list);
        return "user-profile/user-editProfile";
    }
}
