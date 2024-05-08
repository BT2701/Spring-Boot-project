package com.example.demo.Controller;


import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.repository.ThongTinSdRepository;
import com.example.demo.repository.XuLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ThanhVienCTL {
	@Autowired
	private ThanhVienRepository thanhVienRepository;
	@Autowired
	private ThietBiRepository thietBiRepository;
	@Autowired
	private ThongTinSdRepository thongTinSdRepository;
	@Autowired
	private XuLyRepository xuLyRepository;

	@GetMapping("/thanh-vien/getAll")
	@ResponseBody
    public ResponseEntity<List<ThanhVien>> getAllThanhVien() {
		List<ThanhVien> thanhVienList = thanhVienRepository.findAllOrderByLast6Digits();

		return ResponseEntity.ok(thanhVienList);
	}

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

        return "admin-thanhvien";
    }
	@DeleteMapping("/thanhvien/delete/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteThanhVien(@PathVariable Integer id) {
		ThanhVien tv = thanhVienRepository.findById(id).orElse(null);

		if(tv == null) {
			return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + id);
		};

		List<XuLy> xuLy = xuLyRepository.findByThanhVien_MaTV(id);
		List<ThongTinSD> ttsd = thongTinSdRepository.findByThanhVien_MaTV(id);

		System.out.println("id: " + id);
		System.out.println("Số lượng phần tử trong XuLy: " + xuLy);
		System.out.println("Số lượng phần tử trong ThongTinSD: " + ttsd);

		if (!xuLy.isEmpty() || !ttsd.isEmpty()) {
			return ResponseEntity.badRequest().body(String.format("Thành viên với mã : %s đang thực hiện 1 hành động!", id));
		}

		thanhVienRepository.deleteById(id);
		return ResponseEntity.ok(String.format("Đã xóa thành viên với mã : %s thành công !", id));
	};

	@PostMapping("/thanhvien/add")
	@ResponseBody
	public ResponseEntity<?> addThanhVien(
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

		return ResponseEntity.ok(thanhVien);
    };

	@GetMapping("/thanhvien/{maTV}")
	@ResponseBody
	public ResponseEntity<?> getThanhVien(@PathVariable Integer maTV) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);

		if(thanhVien == null) return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + maTV);

		List<XuLy> xuLyList = xuLyRepository.findByThanhVien_MaTV(maTV);
		String xuly = xuLyList.stream()
				.map(XuLy::getHinhThucXL)
				.collect(Collectors.joining(", "));;

		List<ThongTinSD> ttsdList = thongTinSdRepository.findByThanhVien_MaTV(maTV);
		String ttsd = ttsdList.stream()
				.map(thongTinSD -> {
					ThietBi thietBi = thongTinSD.getThietBi();
					return (thietBi != null) ? thietBi.getTenTB() : "Thiết bị không xác định";
				})
				.collect(Collectors.joining(", "));

		Map<String, Object> result = new HashMap<>();
		result.put("thanhVien", thanhVien);
		result.put("viPham", xuly);
		result.put("thietBiDaMuon", ttsd);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/thanhvien/update")
	@ResponseBody
	public ResponseEntity<?> updateThanhVien(
			@RequestParam("maTV") Integer maTV,
			@RequestParam("hoten") String hoten,
			@RequestParam("khoa") String khoa,
			@RequestParam("nganh") String nganh,
			@RequestParam("sdt") String sdt,
			@RequestParam("email") String email,
			@RequestParam("password") String password
	) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
		if(thanhVien != null) {
			thanhVien.setHoTen(hoten);
			thanhVien.setKhoa(khoa);
			thanhVien.setNganh(nganh);
			thanhVien.setSdt(sdt);
			thanhVien.setEmail(email);
			thanhVien.setPassword(password);

			thanhVienRepository.save(thanhVien);
			return ResponseEntity.ok(thanhVien);
		}
		return ResponseEntity.badRequest().body("Lỗi khi sửa thành viên !");
	};

	@PostMapping("/thanhvien/join-kvht")
	@ResponseBody
	public ResponseEntity<?> joinKhuVucHocTap(
			@RequestParam("maTV") Integer maTV
	) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
		if(thanhVien == null) return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + maTV);

		List<ThongTinSD> ttsdList = thongTinSdRepository.findByThanhVien_MaTV(maTV);

		// tìm thấy thì ktra đã vào hay chưa
		Optional<ThongTinSD> ttsd = ttsdList.stream()
				.filter(thongTinSD -> thongTinSD.getTgVao() != null)
				.findFirst();
		if(ttsd.isPresent()) {
			return ResponseEntity.badRequest().body(String.format("Thành viên với mã : %s đã vào khu vực học tập trước đó !", maTV));
		}

		ThongTinSD thongTinSD = new ThongTinSD(new Date(), null, null, null, thanhVien, null);
		thongTinSdRepository.save(thongTinSD);

		return ResponseEntity.ok(String.format("Đã thêm thành viên với mã : %s vào khu vực học tập !", maTV));
	};

    @PostMapping("/thanhvien/muontb")
    @ResponseBody
    public ResponseEntity<?> muonThietBi(
            @RequestParam("maTV") Integer maTV,
            @RequestParam("maTB") Integer maTB
    ) {
        ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
        if(thanhVien == null) return ResponseEntity.badRequest().body("Không tìm thấy thành viên với mã = " + maTV);

        ThietBi thietbi = thietBiRepository.findById(maTB).orElse(null);
        if(thietbi == null) return ResponseEntity.badRequest().body("Không tìm thấy thiết bị với mã = " + maTV);

        List<ThongTinSD> ttsdList = thongTinSdRepository.findAll();

        // Kiểm tra thiết bị đã được mượn chưa
        Optional<ThongTinSD> thongTinSD = ttsdList.stream()
                .filter(ttsd ->
						(ttsd.getThietBi()!= null && Objects.equals(ttsd.getThietBi().getMaTB(), maTB))
						&& ttsd.getTgMuon() != null
						&& ttsd.getTgTra() == null
				)
                .findFirst();
        if(thongTinSD.isPresent()) {
            return ResponseEntity.badRequest().body("Thiết bị này đã được mượn !");
        }

        ThongTinSD ttsd = new ThongTinSD(null, new Date(), null, null, thanhVien, thietbi);
        thongTinSdRepository.save(ttsd);

        return ResponseEntity.ok(String.format("Đã cho thành viên với mã : %s mượn thiết bị có mã : %s !", maTV, maTB));
    };
    @PostMapping("/thanhvien/tratb")
    @ResponseBody
    public ResponseEntity<?> traThietBi(
            @RequestParam("maTV") Integer maTV,
            @RequestParam("maTB") Integer maTB
    ) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
		if (thanhVien == null) {
			return ResponseEntity.badRequest().body("Không tìm thấy thành viên với mã = " + maTV);
		}

		ThietBi thietbi = thietBiRepository.findById(maTB).orElse(null);
		if (thietbi == null) {
			return ResponseEntity.badRequest().body("Không tìm thấy thiết bị với mã = " + maTB);
		}

		Optional<ThongTinSD> thongTinSD = thongTinSdRepository
				.findByThanhVien_MaTV(maTV)
				.stream()
				.filter(ttsd ->
						(ttsd.getThietBi() != null && Objects.equals(ttsd.getThietBi().getMaTB(), maTB))
						&& ttsd.getTgMuon() != null
						&& ttsd.getTgTra() == null)
				.findFirst();

		if (thongTinSD.isPresent()) {
			ThongTinSD ttsd = thongTinSD.get();
			ttsd.setTgTra(new Date());
			thongTinSdRepository.save(ttsd);
			return ResponseEntity.ok("Thành viên có mã: " + maTV + " đã trả thiết bị thành công!");
		} else {
			return ResponseEntity.badRequest().body("Thành viên với mã: " + maTV + " chưa mượn thiết bị này hoặc đã trả.");
		}
    };

	@PostMapping("/thanhvien/cbvp")
	@ResponseBody
	public ResponseEntity<?> canhBaoViPham(
			@RequestParam("maTV") Integer maTV,
			@RequestParam("viPham") String viPham,
			@RequestParam("soTien") Integer soTien
	) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
		if(thanhVien == null) return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + maTV);

		XuLy xl = new XuLy(viPham, soTien == -1 ? null : soTien, new Date(), 1,thanhVien);
		xuLyRepository.save(xl);

		return ResponseEntity.ok(String.format("Đã thêm thành viên với mã : %s vào khu vực học tập !", maTV));
	};

	@GetMapping("/profile")
    public String profile(Model m) {
		Iterable<ThanhVien>list= thanhVienRepository.findAll();
		m.addAttribute("data", list);
        return "user-profile";
    }
	@GetMapping("/profile/editProfile")
    public String editProfile(Model m) {
		Iterable<ThanhVien>list= thanhVienRepository.findAll();
		m.addAttribute("data", list);
        return "user-editProfile";
    }
}
