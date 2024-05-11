package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ThanhVien;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface ThanhVienRepository extends JpaRepository<ThanhVien, Integer> {

    @Query("SELECT tv FROM thanhvien tv ORDER BY CAST(SUBSTRING(CAST(tv.maTV AS STRING), -6, 6) AS INTEGER) ASC")
    List<ThanhVien> findAllOrderByLast6Digits();

    List<ThanhVien> findByHotenContaining(String hoten);

    ThanhVien findByMaTVAndPassword(int maTV, String password);

    // Thêm phương thức để thực hiện việc thêm một bản ghi mới vào bảng ThanhVien
    ThanhVien saveAndFlush(ThanhVien thanhvien);

    boolean existsByEmail(String email);

    boolean existsByMaTV(int maTV);

    ThanhVien findByEmail(String email); // Phương thức mới để lấy thông tin thành viên bằng email

    @Query("SELECT DISTINCT t.khoa FROM thanhvien t WHERE t.khoa IS NOT NULL")
    List<String> findDistinctKhoa();

    @Query("SELECT DISTINCT t.nganh FROM thanhvien t WHERE t.khoa = :khoa AND t.nganh IS NOT NULL")
    List<String> findDistinctNganhByKhoa(@Param("khoa") String khoa);

}
