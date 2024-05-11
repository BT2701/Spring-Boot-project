package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ThietBiRepository;

import java.util.Optional;

public class ThietBiService {

    @Autowired
    private ThietBiRepository thietBiRepository;

    public Integer getNewestId(String tenTB) {
        Optional<Integer> maxIdOptional = thietBiRepository.findMaxIdByTenTB(tenTB);
        Integer maxId = maxIdOptional.orElse(0); // Nếu không tìm thấy giá trị, mặc định là 0
        return maxId + 1;
    }
}
