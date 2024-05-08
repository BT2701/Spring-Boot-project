package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ThanhVien;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ThanhVienRepository extends JpaRepository<ThanhVien, Integer> {

    ThanhVien findByMaTVAndPassword(int maTV, String password);

    // Thêm phương thức để thực hiện việc thêm một bản ghi mới vào bảng ThanhVien
    ThanhVien saveAndFlush(ThanhVien thanhvien);

    boolean existsByEmail(String email);

    boolean existsByMaTV(int maTV);

    ThanhVien findByEmail(String email); // Phương thức mới để lấy thông tin thành viên bằng email

}
// Không cần khai báo phương thức getList, JpaRepository đã cung cấp các phương thức cơ
