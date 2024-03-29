package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.model.entity.BookingEntitySales;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.example.sales_apartment_module.constant.SalesApartmentConstant.*;

@Service
public class ApachePoiServiceImpl implements ApachePoiService {

    public void getReport(List<BookingEntitySales> values) {
        File file = new File(REPORT_FILE);

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rawNumber = 1;
            for (BookingEntitySales value : values) {
                Row row = sheet.createRow(rawNumber++);
                row.createCell(0).setCellValue(String.format(MESSAGE_REPORT_ADDRESS,
                        value.getApartmentId().getAddress().getCity(),
                        value.getApartmentId().getAddress().getStreet(),
                        value.getApartmentId().getAddress().getHomeNumber()));
                row.createCell(1).setCellValue(value.getApartmentId().getPrice());
                row.createCell(2).setCellValue(ChronoUnit.DAYS.between(value.getStartDate(), value.getEndDate()));
                row.createCell(3).setCellValue(value.getApartmentId().getPrice() - value.getFinalCost());
                row.createCell(4).setCellValue(value.getFinalCost());
                row.createCell(5).setCellValue(String.format(MESSAGE_REPORT_DATES,
                        value.getStartDate(),
                        value.getEndDate()));
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы с формированием отчёта");
        }
    }
}
