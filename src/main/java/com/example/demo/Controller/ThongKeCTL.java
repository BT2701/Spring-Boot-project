package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.repository.ThanhVienRepository;


@Controller
public class ThongKeCTL {
	@GetMapping("/thong-ke")
	public String thongKeIndex() {
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
