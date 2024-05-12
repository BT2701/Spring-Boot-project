package com.example.demo.Controller;

import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.service.ThietBiService;
import com.example.demo.service.ThongTinSdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MuonTraCTL {
	@Autowired
	ThongTinSdService thongTinSdService;

	@GetMapping("/DanhSachThietBi")
	public String index(Model model) {
		ArrayList<ThietBi> list= new ArrayList<>();
		for(ThietBi ob:thongTinSdService.getDeviceList()){
			ob.setTrangThai(thongTinSdService.getTrangThaiThietBi(ob.getMaTB()));
			list.add(ob);
		}
		model.addAttribute("list", list);
		return "user-muontra/user-muontra";
	}
}
