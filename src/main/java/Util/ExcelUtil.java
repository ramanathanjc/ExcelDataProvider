package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	/*
	 * This is path for where Excel File Available
	 */
	private static final String TEST_DATA_SHEET_PATH = "./testdata/sample.xlsx";

	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getData(String sheetName) {

		System.out.println("reading data from sheet: " + sheetName);

		Object data[][] = null;

		try {
			// File Input Stream using for Path
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);

			/**
			 * Creates the appropriate HSSFWorkbook / XSSFWorkbook from the given
			 * InputStream. Your input stream MUST either support mark/reset, or be wrapped
			 * as a PushbackInputStream!
			 */
			book = WorkbookFactory.create(ip);

			// Get sheet with the given name
			sheet = book.getSheet(sheetName);

			/**
			 * sheet.getLastRowNum --> Get the last row in excel file
			 * sheet.getRow(0).getLastCellNum() --> Get the first column's last cell
			 */
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

					// i+1 using for ignore the first row because it is for our reference column
					// (Title)
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
					// .toString() using for whatever value we received it will convert to string
					// value

				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
