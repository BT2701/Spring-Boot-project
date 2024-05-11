/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Model.XuLy;
import com.example.demo.repository.XuLyRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lythanhphat9523
 */
@Service
public class XuLyService {
    
    @Autowired
    private XuLyRepository xuLyRepository;
    
    public List<XuLy> findAll() {
        return xuLyRepository.findAll();
    }
    
    public XuLy findById(Integer id) {
        return xuLyRepository.findById(id).get();
    }
    
    public XuLy save(XuLy xuly){
        return xuLyRepository.save(xuly);
    }
    
    public void delete(Integer maxl){
        xuLyRepository.deleteById(maxl);
    }
    
    public void updateXN(Integer maxl) {
        Optional<XuLy> checkXL = xuLyRepository.findById(maxl);
        XuLy xl = checkXL.get();
        xl.setTrangThaiXL(1);
        Date ngay = new Date();
        xl.setNgayXL(ngay);
        xuLyRepository.save(xl);
    }
    
    public void update(XuLy xl) {
        Optional<XuLy> subXL = xuLyRepository.findById(xl.getMaXL());
        XuLy resultXL = subXL.get();
        resultXL.setHinhThucXL(xl.getHinhThucXL());
        resultXL.setThanhVien(xl.getThanhVien());
        resultXL.setSoTien(xl.getSoTien());
        xuLyRepository.save(resultXL);
    }
}
