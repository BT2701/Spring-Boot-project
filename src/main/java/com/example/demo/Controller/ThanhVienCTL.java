package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;
import com.example.demo.service.ThanhVienService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThanhVienCTL {

    @Autowired
    private ThanhVienRepository thanhVienRepository;
    @Autowired
    private ThanhVienService thanhVienService;

    @GetMapping("/thanhvien")
    public String getAllThanhVien(Model m) {
        Iterable<ThanhVien> list = thanhVienRepository.findAll();
        m.addAttribute("data", list);
        return "thanhvien";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam int maTV, @RequestParam String password, Model model) {
        Integer maTVResult = thanhVienService.processLogin(maTV, password, model);
        if (maTVResult != null) {
            model.addAttribute("maTV", maTVResult);
            return "loginsuccess";
        } else {
            model.addAttribute("error", "Email, Số điện thoại hoặc mật khẩu không chính xác");
            return "login";
        }
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestParam String email, @RequestParam int id, @RequestParam String password, Model model) {
        // Kiểm tra xem email hoặc mã sinh viên đã tồn tại trong cơ sở dữ liệu hay không
        boolean emailExists = thanhVienService.emailExists(email);
        boolean idExists = thanhVienService.idExists(id);

        if (emailExists || idExists) {
            // Nếu email hoặc mã sinh viên đã tồn tại, hiển thị thông báo lỗi
            model.addAttribute("error", "Email hoặc Mã Sinh Viên đã tồn tại");
            return "register"; // Trả về trang đăng ký để người dùng thử lại
        } else {
            // Nếu email và mã sinh viên không tồn tại, thêm thành viên mới vào cơ sở dữ liệu
            ThanhVien thanhVien = new ThanhVien();
            thanhVien.setEmail(email);
            thanhVien.setMaTV(id);
            thanhVien.setPassword(password);
            thanhVien.setHoTen("user" + id);

            // Gọi phương thức từ service để thêm bản ghi mới vào bảng ThanhVien
            thanhVienService.addThanhVien(thanhVien);

            // Chuyển hướng đến trang thành công sau khi đăng ký
            return "sign-upSucess";
        }
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
                return "resetpasswordConfirmOTP";
            } else {
                // Nếu gửi OTP không thành công, hiển thị thông báo lỗi
                model.addAttribute("error", "Đã xảy ra lỗi khi gửi OTP, vui lòng thử lại sau");
                return "resetpasword"; // Trả về trang quên mật khẩu với thông báo lỗi
            }

        }

        model.addAttribute("error", "Email không tồn tại trong hệ thống");
        return "resetpasword"; // Trả về trang quên mật khẩu với thông báo lỗi
    }

    @PostMapping("/SendPassword")
    public String SendPassword(@RequestParam String email, Model model) {

        // Nếu email tồn tại, thực hiện gửi OTP
        boolean result = thanhVienService.SendPassword(email);

        // Kiểm tra kết quả gửi OTP
        if (result != false) {
            // Nếu gửi OTP thành công, chuyển hướng đến trang nhập OTP
            return "resetpasswordSucess";
        } else {
            // Nếu gửi OTP không thành công, hiển thị thông báo lỗi
            model.addAttribute("error", "Đã xảy ra lỗi khi gửi password, vui lòng thử lại sau");
            return "login"; // Trả về trang quên mật khẩu với thông báo lỗi
        }
    }

}
