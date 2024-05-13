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

import org.apache.poi.ss.usermodel.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ThanhVienService {
	private final ThanhVienRepository thanhVienRepository;
  private final JavaMailSender javaMailSender;

   	@Autowired
    public ThanhVienService(ThanhVienRepository thanhVienRepository, JavaMailSender javaMailSender) {
        this.thanhVienRepository = thanhVienRepository;
        this.javaMailSender = javaMailSender;
    }

    public List<ThanhVien> getAll() {
        return thanhVienRepository.findAll();
    }


    public ThanhVien getById(int id) {
        return thanhVienRepository.findById(id).orElse(null);
    }

    public ThanhVien add(ThanhVien member) {
        return thanhVienRepository.save(member);
    }

    public ThanhVien update(ThanhVien updatedMember) {
        return thanhVienRepository.save(updatedMember); // Sử dụng save để update nếu đối tượng đã tồn tại
    }

    public void deleteById(int id) {
        thanhVienRepository.deleteById(id);
    }

    public void deleteByCondition(String condition) {
//		thanhVienRepository.deleteByCondition(condition);
    }

    

    public ThanhVien addMember(ThanhVien mem) {
        return thanhVienRepository.save(mem);
    }

	public List<ThanhVien> addMembersFromExcel(Sheet sheet) {
		List<ThanhVien> newMembers = new ArrayList<>();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row currentRow = sheet.getRow(i);
			if (currentRow != null) {
				ThanhVien newMember = parseMemberFromRow(currentRow);
				if (newMember != null) {
					thanhVienRepository.save(newMember);
					newMembers.add(newMember);
				}
			}
		}
		return newMembers;
	}

	private ThanhVien parseMemberFromRow(Row row) {
		String idStr = getCellStringValue(row.getCell(0));

		if(idStr == null || idStr.isEmpty()) {
			return null;
		}

		if(idStr.length() != 10 || !idStr.startsWith("11")) {
			return null;
		}

		int id = Integer.parseInt(idStr);
		if(thanhVienRepository.findById(id).isPresent()) {
			return null;
		}

		String hoTen = getCellStringValue(row.getCell(1));
		String khoa = getCellStringValue(row.getCell(2));
		String nganh = getCellStringValue(row.getCell(3));
		String sdt = getCellStringValue(row.getCell(4));
		String password = getCellStringValue(row.getCell(5));
		String email = getCellStringValue(row.getCell(6));

		return new ThanhVien(id, hoTen, khoa, nganh, sdt, email, password);
	}

	private String getCellStringValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					return df.format(cell.getDateCellValue());
				} else {
					return String.valueOf((int) cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case FORMULA:
				return cell.getCellFormula();
			default:
				return null;
		}
	}


    public ThanhVien processLogin(int maTV, String password, Model model) {
        ThanhVien user = thanhVienRepository.findByMaTVAndPassword(maTV, password);

        if (user != null) {
            // Đăng nhập thành công, trả về maTV
            return user;
        } else {
            // Đăng nhập không thành công, trả về null
            return null;
        }
    }

    // Phương thức để thêm một bản ghi mới vào bảng ThanhVien
    public ThanhVien addThanhVien(ThanhVien thanhVien) {
       try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(thanhVien.getEmail());
            helper.setSubject("Welcome to the system");
            helper.setText("your membership code is: " + thanhVien.getMaTV() +"your password is: "+thanhVien.getPassword());
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
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
        String password = "";
        if (thanhVien != null) {
            password = thanhVien.getPassword();
        }
        // Send OTP via email
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Password Reset");
            helper.setText("Your password is:" + password);
            javaMailSender.send(message);
            return true; // Email sent successfully
        } catch (MessagingException e) {
            e.printStackTrace();
            return false; // Failed to send email
        }
    }

    public List<String> getAllKhoa() {
        return thanhVienRepository.findDistinctKhoa();
    }

    public List<String> findDistinctNganhByKhoa(String khoa) {
        return thanhVienRepository.findDistinctNganhByKhoa(khoa);
    }

}
