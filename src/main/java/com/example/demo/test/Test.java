package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.ThanhVienModel;
import com.example.demo.repository.ThanhVienRepository;


public class Test {
//    private static ThanhVienRepository thanhVienRepository;
//
//    @Autowired
//    public Test(ThanhVienRepository thanhVienRepository) {
//        this.thanhVienRepository = thanhVienRepository;
//    }
//
//    public static void displayAllThanhVien() {
//        // Kiểm tra xem thanhVienRepository có null không
//        if (thanhVienRepository == null) {
//            System.out.println("thanhVienRepository is null!");
//            return;
//        }
//
//        // Lấy danh sách thành viên và hiển thị
//        for (ThanhVienModel tv : thanhVienRepository.findAll()) {
//            System.out.println(tv);
//        }
//    }
//
//    public static void main(String[] args) {
//        // Khởi tạo một đối tượng Test bằng cách sử dụng ApplicationContext
//        // Điều này đảm bảo Spring sẽ inject thanhVienRepository vào Test trước khi sử dụng
//        displayAllThanhVien();
//    }
}
