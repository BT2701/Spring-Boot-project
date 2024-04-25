package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ThanhVienModel;

@Repository
public interface ThanhVienRepository extends JpaRepository<ThanhVienModel, Long>{}
    // Không cần khai báo phương thức getList, JpaRepository đã cung cấp các phương thức cơ 