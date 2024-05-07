/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.Model.XuLy;
import com.example.demo.repository.XuLyRepository;
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
    
    public Optional<XuLy> findById(Integer id) {
        return xuLyRepository.findById(id);
    }
    
    public XuLy save(XuLy xuly){
        return xuLyRepository.save(xuly);
    }
}
