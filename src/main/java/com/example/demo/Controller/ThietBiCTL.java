package com.example.demo.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.Model.ThongTinSD;
import com.example.demo.repository.ThietBiRepository;
import com.example.demo.service.ThietBiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ThietBiCTL {
    @Autowired
    private ThietBiRepository thietBiRepository;

    @Autowired
    private ThietBiService thietBiService;

    @GetMapping("/thiet-bi-admin")
    public String getAllthietBi(Model m) {
        Iterable<ThietBi> tbList = thietBiRepository.findAll();
        m.addAttribute("tbList", tbList);

        return "admin-thietbi/admin-thietbi";
    }

    @GetMapping("/thiet-bi-admin/delete/{id}")
    public ResponseEntity<?> deleteThietBi(@PathVariable Integer id) {
        Optional<ThietBi> tbOptional = thietBiRepository.findById(id);
        Map<String, String> response = new HashMap<>();

        if (tbOptional.isPresent()) {
            ThietBi tb = tbOptional.get();
            List<ThongTinSD> listInfomation = tb.getListInfomation();
            for (ThongTinSD thongTinSD : listInfomation) {
                if (thongTinSD.getTgMuon() != null && thongTinSD.getTgTra() == null) {
                    String tenThanhVien = thongTinSD.getThanhVien().getHoTen();

                    response.put("message", "Xóa thất bại! Thiết bị đang được mượn bởi " + tenThanhVien);
                    return ResponseEntity.ok().body(response);
                }
            }
        } else {
            // Xử lý trường hợp không tìm thấy đối tượng
        }

        thietBiRepository.deleteById(id);
        response.put("message", "Xóa thành công");

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("thiet-bi-admin/newestId/{tenTB}")
    public ResponseEntity<?> getNewestId(@PathVariable String tenTB) {
        Optional<Integer> maxIdOptional = thietBiRepository.findMaxIdByTenTB(tenTB);
        Integer maxId = maxIdOptional.orElse(0); // Nếu không tìm thấy giá trị, mặc định là 0
        Map<String, Integer> response = new HashMap<>();
        response.put("id", maxId + 1);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/thiet-bi-admin/add")
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

    @PostMapping("/thiet-bi-admin/update")
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

    @PostMapping("/thiet-bi-admin/deleteList")
    public ResponseEntity<?> deleteListThietBi(
            @RequestParam("idOp") Integer idOp,
            @RequestParam("tenTB") String ten,
            @RequestParam("moTaTB") String moTa) {
        Iterable<ThietBi> tbList = thietBiRepository.findAll();

        List<Integer> successIds = new ArrayList<>();
        List<Integer> failureIds = new ArrayList<>();

        for (ThietBi thietBi : tbList) {
            Integer id = thietBi.getMaTB();
            String idString = id.toString(); // Chuyển id thành chuỗi để dễ xử lý
            // Kiểm tra xem id của thiết bị có bắt đầu bằng idOp không
            if (idString.startsWith(idOp.toString())) {
                if (thietBi.getTenTB().contains(ten))
                    if (thietBi.getMoTaTB().contains(moTa))
                        // Nếu có, thêm thiết bị vào danh sách đã lọc
                        try {
                            thietBiRepository.deleteById(id);
                            successIds.add(id);
                        } catch (Exception e) {
                            failureIds.add(id);
                            e.printStackTrace(); // In ra stack trace của lỗi
                        }

            }
        }

        Map<String, List<Integer>> responseData = new HashMap<>();
        responseData.put("successIds", successIds);
        responseData.put("failureIds", failureIds);

        return ResponseEntity.ok().body(responseData);
    };

    @PostMapping("/thiet-bi-admin/addListThietBi")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Xử lý file Excel
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File không được rỗng.");
            }
            // Đọc và xử lý file Excel tại đây
            InputStream inputStream = file.getInputStream();
            String result = this.addModelFromFileExcel(inputStream);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xử lý file: " + e.getMessage());
        }
    }

    public String addModelFromFileExcel(InputStream excelInputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(excelInputStream); // Đọc Excel từ InputStream
            Sheet sheet = workbook.getSheetAt(0);

            if (isExcelFormatValid(sheet)) { // Kiểm tra định dạng tệp Excel
                thietBiService.addThietBiFromExcel(sheet); // Thêm thành viên từ Excel
                workbook.close();
                return "Thêm thiết bị từ file Excel thành công.";
            } else {
                workbook.close();
                return "Định dạng của tệp Excel không đúng.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Định dạng của tệp Excel không đúng.";
        }
    }

    private boolean isExcelFormatValid(Sheet sheet) {
        // Kiểm tra số cột của dòng đầu tiên (header) có đúng định dạng không
        Row headerRow = sheet.getRow(0);
        int expectedColumnCount = 3; // Số cột mong muốn
        if (headerRow == null || headerRow.getLastCellNum() != expectedColumnCount) {
            return false;
        }
        // Kiểm tra tên các cột có đúng định dạng không
        String[] expectedColumnNames = { "MaTB", "TenTB", "MoTaTB" };
        for (int i = 0; i < expectedColumnCount; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell == null || !cell.getStringCellValue().equals(expectedColumnNames[i])) {
                return false;
            }
        }

        return true;
    }

    @GetMapping("/thiet-bi-admin/thongTinTB/{id}")
    public ResponseEntity<?> getNguoiMuon(@PathVariable Integer id) {
        Optional<ThietBi> tbOptional = thietBiRepository.findById(id);
        Map<String, String> response = new HashMap<>();

        if (tbOptional.isPresent()) {
            ThietBi tb = tbOptional.get();
            List<ThongTinSD> listInfomation = tb.getListInfomation();
            for (ThongTinSD thongTinSD : listInfomation) {
                if (thongTinSD.getTgMuon() != null && thongTinSD.getTgTra() == null) {
                    String tenThanhVien = thongTinSD.getThanhVien().getHoTen();

                    response.put("message", "Thiết bị đang được mượn bởi " + tenThanhVien);
                    return ResponseEntity.ok().body(response);
                }
            }
        } else {
            // Xử lý trường hợp không tìm thấy đối tượng
        }

        response.put("message", "Thiết bị đang rảnh");

        return ResponseEntity.ok().body(response);
    }

}
