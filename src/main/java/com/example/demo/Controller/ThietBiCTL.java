package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String deleteThietBi(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
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

    @GetMapping("thiet-bi/newestId/{tenTB}")
    public ResponseEntity<?> getNewestId(@PathVariable String tenTB) {
        Optional<Integer> maxIdOptional = thietBiRepository.findMaxIdByTenTB(tenTB);
        Integer maxId = maxIdOptional.orElse(0); // Nếu không tìm thấy giá trị, mặc định là 0
        Map<String, Integer> response = new HashMap<>();
        response.put("id", maxId + 1);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/thiet-bi/add")
    public ResponseEntity<?> addThietBi(
            @RequestParam("idTB") Integer id,
            @RequestParam("tenTB") String ten,
            @RequestParam("moTaTB") String moTa) {
        ThietBi thietBi = new ThietBi(id, ten, moTa);
        Map<String, String> response = new HashMap<>();
        try {
            thietBiRepository.save(thietBi);
            response.put("message", "Thêm thành công");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // TODO: handle exception
            response.put("message", "Thêm thất bại");
            return ResponseEntity.ok().body(response);
        }
    };

    @PostMapping("/thiet-bi/update")
    public ResponseEntity<?> updateThietBi(
            @RequestParam("idTB") Integer id,
            @RequestParam("tenTB") String ten,
            @RequestParam("moTaTB") String moTa) {
        ThietBi thietBi = new ThietBi(id, ten, moTa);
        Map<String, String> response = new HashMap<>();
        try {
            thietBiRepository.save(thietBi);
            response.put("message", "Sửa thành công");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // TODO: handle exception
            response.put("message", "Sửa thất bại");
            return ResponseEntity.ok().body(response);
        }
    };

}
