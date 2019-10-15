package selenium.testing.advance.utilityClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static DataFormatter formatter = new DataFormatter();

	public static Object[][] getData() throws IOException {
		FileInputStream input = new FileInputStream(
				"C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\Testing-Selenium\\dataProvider.xlsx");
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheet("Sheet1");
//		sheet.getRow(2).getCell(0).setCellValue("rahul123");
//		sheet.getRow(2).getCell(1).setCellValue("rahul123");
//		sheet.createRow(3);
//		sheet.getRow(3).createCell(0);
//		sheet.getRow(3).createCell(1);
//		sheet.getRow(3).getCell(0).setCellValue("lalitha");
//		sheet.getRow(3).getCell(1).setCellValue("rahul123");
		XSSFRow row = sheet.getRow(0);
		int row_count = sheet.getPhysicalNumberOfRows();
		int col_count = row.getLastCellNum();
		Object data[][] = new Object[row_count - 1][col_count];
		for (int i = 0; i < row_count - 1; i++) {
			XSSFRow rows = sheet.getRow(i + 1);
			for (int j = 0; j < col_count; j++) {
				XSSFCell cell = rows.getCell(j);
				if (cell == null) {
					data[i][j] = "";
				} else {
					String value = formatter.formatCellValue(cell);
					data[i][j] = value;

				}
			}
		}
		return data;
	}
}
