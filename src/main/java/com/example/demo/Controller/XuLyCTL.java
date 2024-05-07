package com.example.demo.Controller;


import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.XuLy;
import com.example.demo.service.ThanhVienService;
import org.springframework.stereotype.Controller;

import com.example.demo.service.XuLyService;
import jakarta.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class XuLyCTL {
    
    @Autowired
    private XuLyService xuLyService;
    
    @Autowired
    private ThanhVienService tvService;
    
    @GetMapping("/admin-xuly")
    public String xuLyViPham(Model model) {
        List<XuLy> list = xuLyService.findAll();
        model.addAttribute("list", list);
            
        List<ThanhVien> tvlist = tvService.getAll();
        model.addAttribute("tvlist", tvlist);
            
        return "admin-xuly";
    }
        
    @PostMapping("/admin-xuly/add")
    public String themXuLy(@RequestParam Integer MaTV,
            @RequestParam String HinhThucXL,
            @RequestParam(required = false) Integer soTien,
            Model model) {
        ThanhVien tv = tvService.getById(MaTV);
        
        Date ngay = new Date();
        
        
        XuLy xuly = new XuLy(null,HinhThucXL,soTien,ngay,0,tv);
        System.out.println(xuly.toString());

        // Thêm dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ service
        xuLyService.save(xuly);
    
        // Load lại dữ liệu và cập nhật model
        List<XuLy> list = xuLyService.findAll();
        model.addAttribute("list", list);
            
        List<ThanhVien> tvlist = tvService.getAll();
        model.addAttribute("tvlist", tvlist);
        
            // Trả về cùng một trang
        return "admin-xuly";
    }
        
}
