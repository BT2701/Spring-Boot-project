package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;
import org.springframework.ui.Model;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class ThanhVienService {

    private final ThanhVienRepository thanhVienRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public ThanhVienService(ThanhVienRepository thanhVienRepository, JavaMailSender javaMailSender) {
        this.thanhVienRepository = thanhVienRepository;
        this.javaMailSender = javaMailSender;

    }

    public ThanhVien addMember(ThanhVien mem) {
        return thanhVienRepository.save(mem);
    }

    public Integer processLogin(int maTV, String password, Model model) {
        ThanhVien user = thanhVienRepository.findByMaTVAndPassword(maTV, password);

        if (user != null) {
            // Đăng nhập thành công, trả về maTV
            return user.getMaTV();
        } else {
            // Đăng nhập không thành công, trả về null
            return null;
        }
    }

    // Phương thức để thêm một bản ghi mới vào bảng ThanhVien
    public ThanhVien addThanhVien(ThanhVien thanhVien) {

        // Lưu đối tượng thanhVien vào cơ sở dữ liệu
        return thanhVienRepository.saveAndFlush(thanhVien);
    }

    public boolean emailExists(String email) {
        return thanhVienRepository.existsByEmail(email);
    }

    public boolean idExists(int id) {
        return thanhVienRepository.existsByMaTV(id);
    }

//    // Method to send OTP
    public String sendOTP(String email) {
        // Generate OTP
        String otp = generateOTP();

        // Send OTP via email
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("OTP for Password Reset");
            helper.setText("Your OTP for password reset is: " + otp);
            javaMailSender.send(message);
            return "" + otp; // Email sent successfully
        } catch (MessagingException e) {
            e.printStackTrace();
            return "false"; // Failed to send email
        }
    }

    // Method to generate random OTP
    private String generateOTP() {
        // Implement logic to generate OTP
        // For example, using Random class to generate a random 6-digit OTP
        Random random = new Random();
        int otpNumber = 100000 + random.nextInt(900000);
        return String.valueOf(otpNumber);
    }

    public boolean SendPassword(String email) {
        ThanhVien thanhVien = thanhVienRepository.findByEmail(email);
        String password="";
        if (thanhVien != null) {
            password= thanhVien.getPassword();
        } 
        // Send OTP via email
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Password Reset");
            helper.setText("Your password is:"+password);
            javaMailSender.send(message);
            return true; // Email sent successfully
        } catch (MessagingException e) {
            e.printStackTrace();
            return false; // Failed to send email
        }
    }

}
