package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ThanhVien;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ThanhVienRepository extends JpaRepository<ThanhVien, Integer>{
    @Query("SELECT tv FROM thanhvien tv ORDER BY CAST(SUBSTRING(CAST(tv.maTV AS STRING), -6, 6) AS INTEGER) ASC")
    List<ThanhVien> findAllOrderByLast6Digits();

    List<ThanhVien> findByHotenContaining(String hoten);
}
