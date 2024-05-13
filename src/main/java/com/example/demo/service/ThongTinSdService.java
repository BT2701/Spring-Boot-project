package com.example.demo.service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.repository.ThanhVienRepository;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.repository.ThongTinSdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

@Service
public class ThongTinSdService {
    @Autowired
    ThietBiRepository thietBiRepository;
    @Autowired
    ThongTinSdRepository thongTinSdRepository;
    @Autowired
    ThanhVienRepository thanhVienRepository;

    public Iterable<ThietBi> getDeviceList() {
        return thietBiRepository.findAll();
    }
    public ThietBi getDeviceById(Integer id) {
        return thietBiRepository.findById(id).orElse(null);
    }
    public String muonBoi(Integer deviceId) {
        String txt=thongTinSdRepository.muonBoi(deviceId);
        if(txt=="" || txt==null || txt.isEmpty()){
            txt="Thiết bị chưa được mượn";
        }
        return txt;
    }
    public String datBoi(Integer deviceId) {
        String txt=thongTinSdRepository.datBoi(deviceId);
        if(txt=="" || txt==null || txt.isEmpty()){
            txt="Thiết bị chưa được đặt";
        }
        return txt;
    }
    public Iterable<ThongTinSD> getInforList(){
        return thongTinSdRepository.findAll();
    }
    public Iterable<ThanhVien> getMemberList(){
        return thanhVienRepository.findAll();
    }
    public String getTrangThaiThietBi(Integer maTB){
        for(ThongTinSD model: thongTinSdRepository.findAll()){
            if(model.getThietBi()!=null){
                if(model.getThietBi().getMaTB()==maTB && model.getTgDatCho()!=null){
                    return "Đang được đặt";
                }
                else if(model.getThietBi().getMaTB()==maTB && model.getTgMuon()!=null && model.getTgTra()==null){
                    return "Đang được mượn";
                }
            }
        }
        return "Đang rảnh";
    }
    public String datChoMuon(Integer maTB, Integer maTV, Timestamp date){
        ThietBi thietBi=thietBiRepository.findById(maTB).orElse(null);
        if(!thietBi.getListInfomation().isEmpty() || thietBi.getListInfomation()!=null) {
            for (ThongTinSD model : thietBi.getListInfomation()) {
                if (model.getTgDatCho() != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(model.getTgDatCho());
                    int dateData = calendar.get(Calendar.DAY_OF_MONTH);

                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(date);
                    int compareDate = calendar1.get(Calendar.DAY_OF_MONTH);

                    if (dateData == compareDate) {
                        return "Thiết bị đã được đặt chỗ trong ngày " + calendar1.get(Calendar.DAY_OF_MONTH) + "/" + (calendar1.get(Calendar.MONTH) + 1) + "/" + calendar1.get(Calendar.YEAR);
                    }
                }

            }
        }
        ThongTinSD item= new ThongTinSD();
        item.setThanhVien(thanhVienRepository.findById(maTV).orElse(null));
        item.setThietBi(thietBi);
        item.setTgDatCho(date);
        thongTinSdRepository.save(item);
        return "Đặt chỗ thành công!";
    }








    public Iterable<ThongTinSD> findByMaTBAndtGDatchoNotNull(Integer maTB) {
        return thongTinSdRepository.findByMaTBAndtGDatchoNotNull(maTB);
    }
    public void RemoveAllTGDatchoOver1Hour() {
        Iterable<ThongTinSD> listThongTinSD = thongTinSdRepository.findAll();

        // Lấy danh sách thông tin sử dụng ứng với thiết bị
        for (ThongTinSD ttsd : listThongTinSD) {
            // Chuyển Timestamp sang LocalDateTime
            if (ttsd.getTgDatCho() != null) {
                LocalDateTime tgDatCho = ttsd.getTgDatCho().toLocalDateTime();
                LocalDateTime now = LocalDateTime.now();

                if (tgDatCho.plusHours(1).isBefore(now)) {
                    // Hết thời gian đặt chỗ
                    thongTinSdRepository.delete(ttsd);
                }
            }
        }
    }
}
