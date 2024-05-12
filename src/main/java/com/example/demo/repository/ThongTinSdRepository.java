package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ThongTinSD;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThongTinSdRepository extends JpaRepository<ThongTinSD, Integer>{
    List<ThongTinSD> findByThanhVien_MaTV(Integer maTV);

    @Query("SELECT DISTINCT tv.hoten FROM thanhvien tv left join thongtinsd tt on tv.maTV = tt.thanhVien.maTV left join thietbi tb on tb.maTB=tt.thietBi.maTB where tb.maTB= :maTB and tt.tgdatcho is not null ")
    String datBoi(@Param("maTB") Integer maTB);

    @Query("SELECT DISTINCT tv.hoten FROM thanhvien tv left join thongtinsd tt on tv.maTV = tt.thanhVien.maTV left join thietbi tb on tb.maTB=tt.thietBi.maTB where tb.maTB= :maTB and tt.tgMuon is not null and tt.tgTra is null ")
    String muonBoi(@Param("maTB") Integer maTB);
}
