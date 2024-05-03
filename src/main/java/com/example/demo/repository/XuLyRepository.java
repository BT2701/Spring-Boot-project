package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.XuLy;

public interface XuLyRepository extends JpaRepository<XuLy, Integer>{

}
