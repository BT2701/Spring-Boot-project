package com.example.demo.service;

import com.example.demo.Model.ThanhVien;
import com.example.demo.Model.ThietBi;
import com.example.demo.repository.ThietBiRepository;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThietBiService {
    @Autowired
    private ThietBiRepository thietBiRepository;

    public void addThietBiFromExcel(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        DataFormatter dataFormatter = new DataFormatter();

        ArrayList<ThietBi> list = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);
            Cell cell3 = row.getCell(2);

            String value1 = dataFormatter.formatCellValue(cell1);
            String value2 = dataFormatter.formatCellValue(cell2);
            String value3 = dataFormatter.formatCellValue(cell3);

            int id = Integer.parseInt(value1);

            ThietBi thietBiModel = new ThietBi(id, value2, value3);

            list.add(thietBiModel);
        }
        thietBiRepository.saveAll(list);
    }

}
