package com.example.demo.Controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.repository.ThanhVienRepository;
import com.example.demo.service.ThongKeService;


@Controller
public class ThongKeCTL {
	@Autowired
	private ThongKeService thongKeService;
	
	
	@GetMapping("/thong-ke")
	public String thongKeIndex(Model m) {
		m.addAttribute("countMember", thongKeService.countMemberIntoMaterial());
		m.addAttribute("borrowed", thongKeService.countBorrowedDevice());
		m.addAttribute("borrowing", thongKeService.countBorrowingDevice());
		m.addAttribute("violation", thongKeService.countViolation());
		m.addAttribute("handled", thongKeService.countHandledViolation());
		m.addAttribute("handling", thongKeService.countHandlingViolation());
		String txtFee= new DecimalFormat("###,###").format(thongKeService.countFee());
		m.addAttribute("fee", txtFee);
		return "admin-thongke/thong_ke";
	}
	@GetMapping("/thong-ke/member-chart")
	public String member() {
		return "admin-thongke/member_chart";
	}
	@GetMapping("/thong-ke/device-chart")
	public String device() {
		return "admin-thongke/device_chart";
	}
	@GetMapping("/thong-ke/current-chart")
	public String current() {
		return "admin-thongke/current_chart";
	}
	@GetMapping("/thong-ke/handle-chart")
	public String handle() {
		return "admin-thongke/handle_chart";
	}
}
