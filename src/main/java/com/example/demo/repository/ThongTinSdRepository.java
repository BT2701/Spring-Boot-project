package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ThongTinSD;

import java.util.List;

public interface ThongTinSdRepository extends JpaRepository<ThongTinSD, Integer>{
    List<ThongTinSD> findByThanhVien_MaTV(Integer maTV);
}
