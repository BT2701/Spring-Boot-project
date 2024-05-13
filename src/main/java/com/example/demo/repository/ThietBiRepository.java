package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi, Integer> {

    @Query("SELECT MAX(tb.maTB) FROM thietbi tb WHERE tb.tenTB LIKE %:tenTB%")
    Optional<Integer> findMaxIdByTenTB(@Param("tenTB") String tenTB);

}
