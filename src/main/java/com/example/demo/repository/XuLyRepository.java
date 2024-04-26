package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.ThanhVienModel;
import com.example.demo.Model.XuLyModel;

public interface XuLyRepository extends CrudRepository<XuLyModel, Integer>{

}
