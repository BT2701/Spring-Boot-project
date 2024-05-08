package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.repository.ThanhVienRepository;
import org.apache.poi.ss.usermodel.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

		String idStr = Integer.toString(id);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int last2DigitsOfYear = Integer.parseInt(String.valueOf(year).substring(2,4));
		if(idStr.length() != 10 || !idStr.startsWith("11") || Integer.parseInt(idStr.substring(2,4)) > last2DigitsOfYear) {
			return null;
		}

		if(getById(id) != null) {
			return null;
		}

		String hoTen = getCellStringValue(row.getCell(1));
		String khoa = getCellStringValue(row.getCell(2));
		String nganh = getCellStringValue(row.getCell(3));
		String sdt = getCellStringValue(row.getCell(4));
		String email = getCellStringValue(row.getCell(5));
		String password = getCellStringValue(row.getCell(6));

		if (thanhVienRepository.findById(id).isPresent()) {
			return null;
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
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					return df.format(cell.getDateCellValue());
				} else {
					return String.valueOf((int) cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case FORMULA:
				return cell.getCellFormula();
			default:
				return null;
		}
	}
}
