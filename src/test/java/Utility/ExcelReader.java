package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    @SuppressWarnings("deprecation")
	public static void loadRowData(int rowNum) {

        try {
            String excelPath = System.getProperty("user.dir")
                    + "/src/test/resources/TestData/TestData.xlsx";

            FileInputStream fis = new FileInputStream(new File(excelPath));
            Workbook workbook = WorkbookFactory.create(fis);

         
            Sheet sheet = workbook.getSheetAt(0);

            if (sheet == null) {
                throw new RuntimeException("❌ Excel sheet not found");
            }

            // Header row (keys)
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("❌ Header row is missing in Excel");
            }

            // Data row (values)
            Row dataRow = sheet.getRow(rowNum);
            if (dataRow == null) {
                throw new RuntimeException("❌ No data at Excel row: " + rowNum);
            }

            // 🔥 VERY IMPORTANT: clear previous data
            TestDataContext.clear();

            // 🔥 LOAD DATA INTO CONTEXT
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {

                Cell headerCell = headerRow.getCell(i);
                Cell dataCell = dataRow.getCell(i);

                if (headerCell == null) continue;

                String key = headerCell.getStringCellValue().trim();
                String value = "";

                if (dataCell != null) {
                    dataCell.setCellType(CellType.STRING);
                    value = dataCell.getStringCellValue().trim();
                }

                TestDataContext.set(key, value);
            }

            workbook.close();
            fis.close();

            System.out.println("✅ Excel data loaded for row: " + rowNum);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load Excel data", e);
        }
    }
}
