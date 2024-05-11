package com.example.demo.service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.repository.ThanhVienRepository;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.repository.ThongTinSdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongTinSdService {
    @Autowired
    ThietBiRepository thietBiRepository;
    @Autowired
    ThongTinSdRepository thongTinSdRepository;
    @Autowired
    ThanhVienRepository ThanhVienRepository;

    public Iterable<ThietBi> getDeviceList() {
        return thietBiRepository.findAll();
    }
    public Iterable<ThongTinSD> getInforList(){
        return thongTinSdRepository.findAll();
    }
    public Iterable<ThanhVien> getMemberList(){
        return ThanhVienRepository.findAll();
    }
    public String getTrangThaiThietBi(Integer idDevice){
        String trangThai="Đang rảnh";
        for(ThongTinSD model: getInforList()){
            if (model.getThietBi().getMaTB()==idDevice && model.getTgDatCho()!=null){
                trangThai="Đang được đặt";
                return trangThai;
            }
            else if(model.getThietBi().getMaTB()==idDevice && model.getTgMuon()!=null && model.getTgTra()==null){
                trangThai="Đang được mượn";
                return trangThai;
            }
        }


        return trangThai;
    }
}
