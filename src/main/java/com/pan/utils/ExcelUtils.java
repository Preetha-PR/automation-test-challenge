package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import com.pan.exceptions.FrameworkException;
import com.pan.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ExcelUtils {
    private static final Logger logger = LogManager.getLogger(ExcelUtils.class);
    private ExcelUtils(){}

    public static List<Map<String,String>> getTestDetails(String sheetname){
        List<Map<String,String>> list = null;
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetname);

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map =null;
            list = new ArrayList<>();

            for(int i=1; i<=lastrownum;i++) {
                map = new HashMap<>();
                for(int j=0;j<lastcolnum;j++) {
                    String key= sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
logger.info("TestManager read successfully");
        } catch (FileNotFoundException e) {
            logger.info("Error reading TestManager Excel File - FileNotFoundException");
            throw new InvalidPathForExcelException("Excel File you trying to read is not found");
        } catch (IOException e) {
            logger.info("Error reading TestManager Excel File - IO Exception");
            throw new FrameworkException("IO Exception while reading the excel file");
        }
        return list;
    }
}
