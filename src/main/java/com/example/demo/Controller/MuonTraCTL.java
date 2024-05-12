package com.example.demo.Controller;

import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.service.ThietBiService;
import com.example.demo.service.ThongTinSdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MuonTraCTL {
	@Autowired
	ThongTinSdService thongTinSdService;

	@GetMapping("/DanhSachThietBi")
	public String index(Model model, @RequestParam("maTV")Integer maTV) {
		ArrayList<ThietBi> list= new ArrayList<>();
		for(ThietBi ob:thongTinSdService.getDeviceList()){
			ob.setTrangThai(thongTinSdService.getTrangThaiThietBi(ob.getMaTB()));
			list.add(ob);
		}
		model.addAttribute("maTV", maTV);
		model.addAttribute("list", list);
		return "user-muontra/user-muontra";
	}

	@GetMapping("api/DanhSachThietBi")
	@ResponseBody
	public Map<String, Object> getDeviceById(@RequestParam("maTB") Integer maTB) {
		Map<String, Object> result = new HashMap<>();
		ThietBi thietBi=thongTinSdService.getDeviceById(maTB);
		thietBi.setTrangThai(thongTinSdService.getTrangThaiThietBi(maTB));
		String nguoiMuon= thongTinSdService.muonBoi(maTB);
		String nguoiDat= thongTinSdService.datBoi(maTB);
		result.put("thietBi", thietBi);
		result.put("nguoiMuon", nguoiMuon);
		result.put("nguoiDat", nguoiDat);
		return result;
	}
	@GetMapping("api/muontra")
	@ResponseBody
	public Map<String, Object> datChoMuonThietBi(@RequestParam("maTB") Integer maTB,
							  @RequestParam("maTV") Integer maTV,
							  @RequestParam("tgDatCho")Timestamp tgDatCho) {
		Map<String, Object> result = new HashMap<>();
		String txt= thongTinSdService.datChoMuon(maTB, maTV, tgDatCho);
		result.put("txt", txt);
		return result;
	}
}
