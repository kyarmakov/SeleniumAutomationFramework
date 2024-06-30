package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {
    private ExcelUtils() {}

    public static List<Map<String, String>> getTests(String sheetName) {
        FileInputStream fs;
        XSSFWorkbook workbook;
        XSSFSheet sheet;

        try {
            fs = new FileInputStream(FrameworkConstants.getExcelPath());
            workbook = new XSSFWorkbook(fs);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        int lastRowNum = sheet.getLastRowNum();
        int lastColNum = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i <= lastRowNum; i++) {
            map = new HashMap<>();
            for (int j = 0; j < lastColNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
            }
            list.add(map);
        }

        return list;
    }
}
