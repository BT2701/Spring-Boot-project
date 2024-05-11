package com.example.demo.Controller;

import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.Model.XuLy;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.repository.ThongTinSdRepository;
import com.example.demo.repository.XuLyRepository;
import com.example.demo.service.ThanhVienService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import org.hibernate.query.sqm.CastType;
import org.springframework.http.HttpStatus;

@Controller
public class ThanhVienCTL {

    @Autowired
    private ThanhVienRepository thanhVienRepository;
    @Autowired
    private ThanhVienService thanhVienService;
    @Autowired
    private ThietBiRepository thietBiRepository;
    @Autowired
    private ThongTinSdRepository thongTinSdRepository;
    @Autowired
    private XuLyRepository xuLyRepository;

    @PostMapping("/login")
    public String processLogin(@RequestParam int maTV, @RequestParam String password, Model model, HttpServletRequest request) {
        ThanhVien TVResult = thanhVienService.processLogin(maTV, password, model);
        if (TVResult != null) {
            // Lưu thông tin người dùng vào session
            request.getSession().setAttribute("maTV", TVResult.getMaTV());
            request.getSession().setAttribute("HoTen", TVResult.getHoTen());
            if (TVResult.getMaTV() == 1111111111) {
                //dang nhap vao admin
                return "slider/slider";

            } else {
                //dang nhap vao user
                return "user-muontra/user-muontra";
            }
        } else {
            model.addAttribute("error", "Email, Số điện thoại hoặc mật khẩu không chính xác");
            return "login-signup/login";
        }
    }

    @GetMapping("/thanh-vien/getAll")
    @ResponseBody
    public ResponseEntity<List<ThanhVien>> getAllThanhVien() {
        List<ThanhVien> thanhVienList = thanhVienRepository.findAllOrderByLast6Digits();

        return ResponseEntity.ok(thanhVienList);
    }

    @GetMapping("/thanh-vien-admin")
    public String getAllThanhVien(Model m, @RequestParam(value = "keyword", required = false) String keyword) {
        Iterable<ThanhVien> tvList;
        Iterable<ThietBi> tbList = thietBiRepository.findAll();

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

    @DeleteMapping("/thanhvien/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteThanhVien(@PathVariable Integer id) {
        ThanhVien tv = thanhVienRepository.findById(id).orElse(null);

        if (tv == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + id);
        };

        List<XuLy> xuLy = xuLyRepository.findByThanhVien_MaTV(id);
        List<ThongTinSD> ttsd = thongTinSdRepository.findByThanhVien_MaTV(id);

        if (!xuLy.isEmpty() || !ttsd.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("Thành viên với mã : %s đang thực hiện 1 hành động!", id));
        }

        thanhVienRepository.deleteById(id);
        return ResponseEntity.ok(String.format("Đã xóa thành viên với mã : %s thành công !", id));
    }

    ;

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
    }

    ;

	@PostMapping("/upload-excel")
	@ResponseBody
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		try {
			// Xử lý file Excel
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File không được rỗng.");
			}
			// Đọc và xử lý file Excel tại đây
			InputStream inputStream = file.getInputStream();
			String result = this.addModelFromFileExcel(inputStream);

			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Lỗi khi xử lý file: " + e.getMessage());
		}
	}
	public String addModelFromFileExcel(InputStream excelInputStream) {
		try {
			Workbook workbook = new XSSFWorkbook(excelInputStream); // Đọc Excel từ InputStream
			Sheet sheet = workbook.getSheetAt(0);

			if (isExcelFormatValid(sheet)) { // Kiểm tra định dạng tệp Excel
				thanhVienService.addMembersFromExcel(sheet); // Thêm thành viên từ Excel
				workbook.close();
				return "Thêm thành viên từ file Excel thành công.";
			} else {
				workbook.close();
				return "Định dạng của tệp Excel không đúng.";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Định dạng của tệp Excel không đúng.";
		}
	}
	private boolean isExcelFormatValid(Sheet sheet) {
		// Kiểm tra số cột của dòng đầu tiên (header) có đúng định dạng không
		Row headerRow = sheet.getRow(0);
		int expectedColumnCount = 7; // Số cột mong muốn
		if (headerRow == null || headerRow.getLastCellNum() != expectedColumnCount) {
			return false;
		}

		// Kiểm tra tên các cột có đúng định dạng không
		String[] expectedColumnNames = {"MaTV", "Ho Ten", "Khoa", "Nganh", "SDT", "email", "password"};
		for (int i = 0; i < expectedColumnCount; i++) {
			Cell cell = headerRow.getCell(i);
			if (cell == null || !cell.getStringCellValue().equals(expectedColumnNames[i])) {
				return false;
			}
		}

		return true;
	}

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
				.filter(thongTinSD -> thongTinSD.getThietBi() != null)
				.map(thongTinSD -> thongTinSD.getThietBi().getTenTB())
				.collect(Collectors.joining(", "));

		String tbddc = ttsdList.stream()
				.filter(thongTinSD -> thongTinSD.getTgDatCho() != null)
				.map(thongTinSD -> thongTinSD.getThietBi().getTenTB())
				.collect(Collectors.joining(", "));

		Map<String, Object> result = new HashMap<>();
		result.put("thanhVien", thanhVien);
		result.put("viPham", xuly);
		result.put("thietBiDaMuon", ttsd);
		result.put("thietBiDaDatCho", tbddc);

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
        if (thanhVien == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + maTV);
        }

        List<ThongTinSD> ttsdList = thongTinSdRepository.findByThanhVien_MaTV(maTV);

        // tìm thấy thì ktra đã vào hay chưa
        Optional<ThongTinSD> ttsd = ttsdList.stream()
                .filter(thongTinSD -> thongTinSD.getTgVao() != null)
                .findFirst();
        if (ttsd.isPresent()) {
            return ResponseEntity.badRequest().body(String.format("Thành viên với mã : %s đã vào khu vực học tập trước đó !", maTV));
        }

        ThongTinSD thongTinSD = new ThongTinSD(new Date(), null, null, null, thanhVien, null);
        thongTinSdRepository.save(thongTinSD);

        return ResponseEntity.ok(String.format("Đã thêm thành viên với mã : %s vào khu vực học tập !", maTV));
    }

    ;

    @PostMapping("/thanhvien/muontb")
    @ResponseBody
    public ResponseEntity<?> muonThietBi(
            @RequestParam("maTV") Integer maTV,
            @RequestParam("maTB") Integer maTB
    ) {
        ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
        if (thanhVien == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy thành viên với mã = " + maTV);
        }

        ThietBi thietbi = thietBiRepository.findById(maTB).orElse(null);
        if (thietbi == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy thiết bị với mã = " + maTV);
        }

        List<ThongTinSD> ttsdList = thongTinSdRepository.findAll();

        // Kiểm tra thiết bị đã được mượn chưa
        Optional<ThongTinSD> thongTinSD = ttsdList.stream()

                .filter(ttsd
                        -> (ttsd.getThietBi() != null && Objects.equals(ttsd.getThietBi().getMaTB(), maTB))
                && ttsd.getTgMuon() != null
                && ttsd.getTgTra() == null
                )
                .findFirst();
        if (thongTinSD.isPresent()) {
            return ResponseEntity.badRequest().body("Thiết bị này đã được mượn !");

        }

        ThongTinSD ttsd = new ThongTinSD(null, new Date(), null, null, thanhVien, thietbi);
        thongTinSdRepository.save(ttsd);

        return ResponseEntity.ok(String.format("Đã cho thành viên với mã : %s mượn thiết bị có mã : %s !", maTV, maTB));
    }

    ;
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
                .filter(ttsd
                        -> (ttsd.getThietBi() != null && Objects.equals(ttsd.getThietBi().getMaTB(), maTB))
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
    }

    ;

	@PostMapping("/thanhvien/cbvp")
    @ResponseBody
    public ResponseEntity<?> canhBaoViPham(
            @RequestParam("maTV") Integer maTV,
            @RequestParam("viPham") String viPham,
            @RequestParam("soTien") Integer soTien
    ) {
        ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);
        if (thanhVien == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy thành viên với maTV = " + maTV);
        }

        XuLy xl = new XuLy(viPham, soTien == -1 ? null : soTien, new Date(), 1, thanhVien);
        xuLyRepository.save(xl);

        return ResponseEntity.ok(String.format("Đã thêm thành viên với mã : %s vào khu vực học tập !", maTV));
    }

    ;

    @DeleteMapping("/thanhvien/delete-multiple")
    @ResponseBody
    public ResponseEntity<?> deleteMultipleThanhVien(@RequestBody Map<String, String> criteria) {
        String khoaThu = criteria.get("khoaThu");
        String hoTen = criteria.get("hoTen");
        String khoa = criteria.get("khoa");
        String nganh = criteria.get("nganh");
        String sdt = criteria.get("sdt");

        List<ThanhVien> thanhViensToDelete = thanhVienRepository.findAll().stream()
                .filter(tv -> {
                    boolean matches = true;
                    if (khoaThu != null && !khoaThu.isEmpty()) {
                        String maTVStr = Integer.toString(tv.getMaTV());
                        matches = matches && maTVStr.length() == 10 && maTVStr.substring(2, 4).equals(khoaThu);
                    }
                    if (hoTen != null && !hoTen.isEmpty()) {
                        matches = matches && tv.getHoTen().contains(hoTen);
                    }
                    if (khoa != null && !khoa.isEmpty()) {
                        matches = matches && tv.getKhoa().equals(khoa);
                    }
                    if (nganh != null && !nganh.isEmpty()) {
                        matches = matches && tv.getNganh().equals(nganh);
                    }
                    if (sdt != null && !sdt.isEmpty()) {
                        matches = matches && tv.getSdt().equals(sdt);
                    }

                    // kiểm tra khóa ngoại
                    List<XuLy> xuLy = xuLyRepository.findByThanhVien_MaTV(tv.getMaTV());
                    List<ThongTinSD> ttsd = thongTinSdRepository.findByThanhVien_MaTV(tv.getMaTV());

                    if (!xuLy.isEmpty() || !ttsd.isEmpty()) {
                        matches = false;
                    }

                    return matches;
                })
                .collect(Collectors.toList());

        thanhVienRepository.deleteAll(thanhViensToDelete);
        return ResponseEntity.ok("Đã xóa thành công " + thanhViensToDelete.size() + " thành viên.");
    }

    @GetMapping("/profile")
    public String profile(Model m, @RequestParam(name = "id") Integer maTV) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);

		if(thanhVien == null) return "login-signup/login";

		List<XuLy> xuLyList = xuLyRepository.findByThanhVien_MaTV(maTV);
		String xuly = xuLyList.stream()
				.map(XuLy::getHinhThucXL)
				.collect(Collectors.joining(", "));;

		List<ThongTinSD> ttsdList = thongTinSdRepository.findByThanhVien_MaTV(maTV);
		String ttsd = ttsdList.stream()
				.filter(thongTinSD -> thongTinSD.getThietBi() != null && thongTinSD.getTgMuon() != null && thongTinSD.getTgTra() != null)
				.map(thongTinSD -> thongTinSD.getThietBi().getTenTB())
				.collect(Collectors.joining(", "));

		String tbddc = ttsdList.stream()
				.filter(thongTinSD -> thongTinSD.getTgDatCho() != null)
				.map(thongTinSD -> thongTinSD.getThietBi().getTenTB())
				.collect(Collectors.joining(", "));

		Map<String, Object> result = new HashMap<>();
		result.put("thanhVien", thanhVien);
		result.put("viPham", xuly);
		result.put("thietBiDaMuon", ttsd);
		result.put("thietBiDaDatCho", tbddc);

		m.addAttribute("data", result);
        return "user-profile/user-profile";
    }
	@GetMapping("/profile/editProfile")
    public String editProfile(Model m, @RequestParam(name = "id") Integer maTV, RedirectAttributes redirectAttrs) {
		ThanhVien thanhVien = thanhVienRepository.findById(maTV).orElse(null);

		if(thanhVien == null) return "login-signup/login";

		m.addAttribute("data", thanhVien);
        return "user-profile/user-editProfile";
    }

    @PostMapping("/SendOTP")
    public String sendOTP(@RequestParam String email, Model model) {
        // Kiểm tra xem email có tồn tại trong hệ thống không
        boolean emailExists = thanhVienService.emailExists(email);

        // Nếu không tồn tại, hiển thị thông báo lỗi
        if (emailExists) {

            // Nếu email tồn tại, thực hiện gửi OTP
            String otpSent = thanhVienService.sendOTP(email);

            // Kiểm tra kết quả gửi OTP
            if (otpSent != "false") {
                model.addAttribute("otp", Integer.parseInt(otpSent)); // Thay "otp" bằng biến OTP bạn đã sinh ra
                model.addAttribute("email", email); // Thay "otp" bằng biến OTP bạn đã sinh ra

                // Nếu gửi OTP thành công, chuyển hướng đến trang nhập OTP
                return "login-signup/resetpasswordConfirmOTP";
            } else {
                // Nếu gửi OTP không thành công, hiển thị thông báo lỗi
                model.addAttribute("error", "Đã xảy ra lỗi khi gửi OTP, vui lòng thử lại sau");
                return "login-signup/resetpasword"; // Trả về trang quên mật khẩu với thông báo lỗi
            }

        }

        model.addAttribute("error", "Email không tồn tại trong hệ thống");
        return "login-signup/resetpasword"; // Trả về trang quên mật khẩu với thông báo lỗi
    }

    @PostMapping("/SendPassword")
    public String SendPassword(@RequestParam String email, Model model) {

        // Nếu email tồn tại, thực hiện gửi OTP
        boolean result = thanhVienService.SendPassword(email);

        // Kiểm tra kết quả gửi OTP
        if (result != false) {
            // Nếu gửi OTP thành công, chuyển hướng đến trang nhập OTP
            return "login-signup/resetpasswordSucess";
        } else {
            // Nếu gửi OTP không thành công, hiển thị thông báo lỗi
            model.addAttribute("error", "Đã xảy ra lỗi khi gửi password, vui lòng thử lại sau");
            return "login-signup/login"; // Trả về trang quên mật khẩu với thông báo lỗi
        }
    }

    @GetMapping("/getAllKhoa")
    public ResponseEntity<List<String>> getAllKhoa() {
        List<String> khoaList = thanhVienService.getAllKhoa();
        return new ResponseEntity<>(khoaList, HttpStatus.OK);
    }

    @PostMapping("/nganhByKhoa")
    @ResponseBody
    public List<String> getNganhByKhoa(@RequestParam String khoa) {
        return thanhVienService.findDistinctNganhByKhoa(khoa);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestParam String id, @RequestParam String email, @RequestParam String khoa, @RequestParam String Nganh, @RequestParam String password, Model model) {
        // Kiểm tra xem email hoặc mã sinh viên đã tồn tại trong cơ sở dữ liệu hay không
        int maTV = Integer.parseInt(id);
        boolean emailExists = thanhVienService.emailExists(email);
        boolean idExists = thanhVienService.idExists(maTV);

        if (emailExists || idExists) {
            return ResponseEntity.ok("Email hoặc Mã Sinh Viên đã tồn tại");
        } else {
            // Nếu email và mã sinh viên không tồn tại, thêm thành viên mới vào cơ sở dữ liệu
            ThanhVien thanhVien = new ThanhVien();
            thanhVien.setMaTV(maTV);
            thanhVien.setEmail(email);
            thanhVien.setKhoa(khoa);
            thanhVien.setNganh(Nganh);
            thanhVien.setPassword(password);
            thanhVien.setHoTen("user" + id);

            // Gọi phương thức từ service để thêm bản ghi mới vào bảng ThanhVien
            thanhVienService.addThanhVien(thanhVien);
            // Chuyển hướng đến trang thành công sau khi đăng ký
            return ResponseEntity.ok("done");
        }

    }

}
