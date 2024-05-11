package com.example.demo.Controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.Model.ThongKe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
//	1. THỐNG KÊ TỔNG QUAN
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
	@GetMapping("/api/thong-ke")
	@ResponseBody // Đánh dấu để Spring trả về kết quả như là dữ liệu JSON
	public ThongKe thongKeByDateRange(
			@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

		ThongKe ThongKe = new ThongKe();

		// Lấy dữ liệu thống kê từ service
		int countMember = thongKeService.countIntoMaterialOverTime(fromDate, toDate);
		int borrowed = thongKeService.countBorrowedDeviceOverTime(fromDate, toDate);
		int borrowing = thongKeService.countBorrowingDeviceOverTime(fromDate, toDate);
		int violation = thongKeService.countViolationOverTime(fromDate, toDate);
		int handled = thongKeService.countHandledViolationOverTime(fromDate, toDate);
		int handling = thongKeService.countHandlingViolationOverTime(fromDate, toDate);
		int fee = thongKeService.countFeeOverTime(fromDate, toDate);

		// Đặt các giá trị vào đối tượng ThongKe
		ThongKe.setCountMember(countMember);
		ThongKe.setBorrowed(borrowed);
		ThongKe.setBorrowing(borrowing);
		ThongKe.setViolation(violation);
		ThongKe.setHandled(handled);
		ThongKe.setHandling(handling);
		ThongKe.setFee(fee);

		return ThongKe;
	}




	//	END 1.
	@GetMapping("/member-chart")
	public String member() {

		return "admin-thongke/member_chart";
	}
	@GetMapping("/device-chart")
	public String device() {

		return "admin-thongke/device_chart";
	}
	@GetMapping("/current-chart")
	public String current() {

		return "admin-thongke/current_chart";
	}
	@GetMapping("/handle-chart")
	public String handle() {

		return "admin-thongke/handle_chart";
	}
}
