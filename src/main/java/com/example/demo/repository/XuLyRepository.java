package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.XuLy;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface XuLyRepository extends JpaRepository<XuLy, Integer>{
    List<XuLy> findByThanhVien_MaTV(Integer maTV);
    @Query("SELECT x FROM xuly x INNER JOIN x.thanhVien tv WHERE tv.maTV = :id and x.trangthaixl = 1 ORDER BY x.ngayXL DESC")
    public Iterable<XuLy> findByThanhVienId(@Param("id") Integer id);
}
