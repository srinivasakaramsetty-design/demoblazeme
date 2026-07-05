package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    String path = "src/test/resources/testdata/LoginData.xlsx";

    public Object[][] getExcelData(String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheet(sheetName);
            
            System.out.println("Sheet Name Requested : " + sheetName);

            System.out.println("Available Sheets:");

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println(workbook.getSheetName(i));
            }

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= rows; i++) {

                for (int j = 0; j < cols; j++) {

                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }

            workbook.close();
            fis.close();

            return data;

        } catch (Exception e) {

            e.printStackTrace();
            return new Object[0][0];
        }
    }
    
    

}