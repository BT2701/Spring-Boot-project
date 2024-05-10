package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.repository.ThietBiRepository;

@Controller
public class ThietBiCTL {
    @Autowired
    private ThietBiRepository thietBiRepository;

    @GetMapping("/thiet-bi")
    public String getAllthietBi(Model m, @RequestParam(name = "message", required = false) String message) {
        Iterable<ThietBi> tbList = thietBiRepository.findAll();
        m.addAttribute("tbList", tbList);
        if (message != null) {
            m.addAttribute("message", message);
        }
        return "admin-thietbi/admin-thietbi";
    }

    @GetMapping("/thiet-bi/delete/{id}")
    public String deleteThanhVien(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<ThietBi> tbOptional = thietBiRepository.findById(id);
        if (tbOptional.isPresent()) {
            ThietBi tb = tbOptional.get();
            List<ThongTinSD> listInfomation = tb.getListInfomation();
            for (ThongTinSD thongTinSD : listInfomation) {
                if (thongTinSD.getTgMuon() != null && thongTinSD.getTgTra() == null) {
                    String tenThanhVien = thongTinSD.getThanhVien().getHoTen();
                    redirectAttributes.addAttribute("message",
                            "Xóa thất bại! Thiết bị đang được mượn bởi " + tenThanhVien);
                    return "redirect:/thiet-bi";
                }
            }
        } else {
            // Xử lý trường hợp không tìm thấy đối tượng
        }

        thietBiRepository.deleteById(id);
        redirectAttributes.addAttribute("message", "Xóa thành công");

        return "redirect:/thiet-bi";
    }

}
