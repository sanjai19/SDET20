package com.vtiger.comcast.gereriUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Sanjai
 *
 */

public class ExcelUtility {
	
	
/*public static void main(String[] args) throws Throwable   {
		
		String XLFilepath = "./resource/Book1.xlsx";
		FileInputStream fin = new FileInputStream(XLFilepath);
		Workbook workbook = WorkbookFactory.create(fin);
		 Sheet sheet = workbook.getSheet("Sheet1");
		 int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 0; i <= rowcount-1; i++) {
			for (int j = 0; j <= cellcount-1; j++) {
				//System.out.println(sheet.getRow(i).getCell(j).toString());
				
			}
			
		}
	}*/
	
		/**
		 *  its used read the data from excel base don below arguments 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throws Throwable
		 */
		public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
			FileInputStream fis  = new FileInputStream("./datafile/datafile.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(celNum).getStringCellValue();
			wb.close();
			return data;
		}
		/**
		 * used to get the last used row number on specified Sheet
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream("./datafile/datafile.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}
		
		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
			FileInputStream fis  = new FileInputStream("./datafile/datafile.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("./datafile/datafile.xlsx");
			wb.write(fos);
			wb.close();
			
		}

	

}
