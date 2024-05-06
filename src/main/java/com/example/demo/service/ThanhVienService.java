package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThanhVienService {
	private final ThanhVienRepository thanhVienRepository;
	
	@Autowired
	public ThanhVienService(ThanhVienRepository thanhVienRepository) {
		this.thanhVienRepository=thanhVienRepository;
	}
	public List<ThanhVien> getAll() {
		return thanhVienRepository.findAll();
	}

	public ThanhVien getById(int id) {
		return thanhVienRepository.findById(id).orElse(null);
	}

	public ThanhVien add(ThanhVien member) {
		return thanhVienRepository.save(member);
	}

	public ThanhVien update(ThanhVien updatedMember) {
		return thanhVienRepository.save(updatedMember); // Sử dụng save để update nếu đối tượng đã tồn tại
	}

	public void deleteById(int id) {
		thanhVienRepository.deleteById(id);
	}

	public void deleteByCondition(String condition) {
//		thanhVienRepository.deleteByCondition(condition);
	}

	public List<ThanhVien> addMembersFromExcel(Sheet sheet) {
		List<ThanhVien> newMembers = new ArrayList<>();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row currentRow = sheet.getRow(i);
			if (currentRow != null) {
				ThanhVien newMember = parseMemberFromRow(currentRow);
				if (newMember != null) {
					thanhVienRepository.save(newMember);
					newMembers.add(newMember);
				}
			}
		}
		return newMembers;
	}

	private ThanhVien parseMemberFromRow(Row row) {
		int id = (int) row.getCell(0).getNumericCellValue();

		String hoTen = getCellStringValue(row.getCell(1));
		String khoa = getCellStringValue(row.getCell(2));
		String nganh = getCellStringValue(row.getCell(3));
		String sdt = getCellStringValue(row.getCell(4));
		String email = getCellStringValue(row.getCell(5));
		String password = getCellStringValue(row.getCell(6));

		if (thanhVienRepository.findById(id).isPresent()) {
			return null; // Nếu thành viên đã tồn tại
		}

		return new ThanhVien(id, hoTen, khoa, nganh, sdt, email, password);
	}

	private String getCellStringValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			default:
				return null;
		}
	}

	// hàm thêm bên ctl cũ

//	public String addModelFromFileExcel(String filePath) {
//		try {
//			FileInputStream excelFile = new FileInputStream(new File(filePath));
//			Workbook workbook = new XSSFWorkbook(excelFile);
//			Sheet sheet = workbook.getSheetAt(0);
//
//			// Kiểm tra định dạng của tệp Excel
//			if (isExcelFormatValid(sheet)) {
//				dal.addModelFromFileExcel(sheet);
//				workbook.close();
//				return "Thêm thành viên từ file Excel thành công.";
//			} else {
//				workbook.close();
//				return "Định dạng của tệp Excel không đúng.";
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "Định dạng của tệp Excel không đúng.";
//		}
//	}
//
//	private boolean isExcelFormatValid(Sheet sheet) {
//		// Kiểm tra số cột của dòng đầu tiên (header) có đúng định dạng không
//		Row headerRow = sheet.getRow(0);
//		int expectedColumnCount = 7; // Số cột mong muốn
//		if (headerRow == null || headerRow.getLastCellNum() != expectedColumnCount) {
//			return false;
//		}
//
//		// Kiểm tra tên các cột có đúng định dạng không
//		String[] expectedColumnNames = {"MaTV", "Ho Ten", "Khoa", "Nganh", "SDT", "email", "password"};
//		for (int i = 0; i < expectedColumnCount; i++) {
//			Cell cell = headerRow.getCell(i);
//			if (cell == null || !cell.getStringCellValue().equals(expectedColumnNames[i])) {
//				return false;
//			}
//		}
//
//		return true;
//	}
}
