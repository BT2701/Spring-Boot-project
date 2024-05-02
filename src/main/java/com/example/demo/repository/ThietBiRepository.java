package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ThanhVienModel;
import com.example.demo.Model.ThietBiModel;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBiModel, Integer>{

}
