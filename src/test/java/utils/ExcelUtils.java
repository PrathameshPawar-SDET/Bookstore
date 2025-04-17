package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getTestData(String path, String sheetname){
        try(FileInputStream file = new FileInputStream(path)){
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetname);
            int rowcount = sheet.getPhysicalNumberOfRows();
            int colscount = sheet.getRow(0).getPhysicalNumberOfCells();


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
