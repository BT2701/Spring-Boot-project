package com.example.demo.Controller;

import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.service.DateService;
import com.example.demo.service.ThietBiService;
import com.example.demo.service.ThongTinSdService;
import com.example.demo.service.XuLyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MuonTraCTL {
	@Autowired
	ThongTinSdService thongTinSdService;
    @Autowired
    private XuLyService xuLyService;

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
							  @RequestParam("tgDatCho")String tgDatCho) {
		thongTinSdService.RemoveAllTGDatchoOver1Hour();
		Timestamp tg= new Timestamp(Long.parseLong(tgDatCho));
		Map<String, Object> result = new HashMap<>();
		String txt= thongTinSdService.datChoMuon(maTB, maTV, tg);
		result.put("txt", txt);
		return result;
	}







//	public static Integer TryParseInt(String txt) {
//		try {
//			return Integer.parseInt(txt);
//		} catch (NumberFormatException ex) {
//			return null;
//		}
//	}
//	@GetMapping("/DanhSachThietBi/{id}")
//	public String getDatCho(@PathVariable("id") ThietBi thietBi, Model model, HttpSession session) {
//		thongTinSdService.RemoveAllTGDatchoOver1Hour();
//
//		Iterable<ThongTinSD> listTTSD = thongTinSdService.findByMaTBAndtGDatchoNotNull(thietBi.getMaTB());
//
//		// Chỉ thêm vào nếu ngày đặt chỗ là hôm nay
//		for (ThongTinSD ttsd : listTTSD) {
//			LocalDate localDateNow = DateService.dateTypeToLocalDateType(new Date());
//			LocalDate localDatetGDatcho = DateService.dateTypeToLocalDateType(ttsd.getTgDatCho());
//			if (localDateNow.equals(localDatetGDatcho)) {
//				model.addAttribute("ttsd", ttsd);
//				model.addAttribute("tgDatChoHomNay", true);
//				break;
//			}
//		}
//
//		model.addAttribute("username", session.getAttribute("username").toString());
//		model.addAttribute("thietBi", thietBi);
//		return "user-muontra/user-muontra";
//	}
}
