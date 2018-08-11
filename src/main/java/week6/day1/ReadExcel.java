package week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public Object[][] readExcel(String fileName) throws IOException {

		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//go to sheet
		XSSFSheet sheet = wbook.getSheetAt(0);
		//find the row count
		int rowCount = sheet.getLastRowNum();
		//find the column count
		int colCount = sheet.getRow(0).getLastCellNum();
		//Read the data
		Object [][] data= new Object [rowCount][colCount];
		for (int i =1; i<= rowCount;i++)
		{
			XSSFRow row= sheet.getRow(i);
			for (int j=0; j<colCount;j++) {
				try {
					XSSFCell cell = row.getCell(j);
					 data [i-1][j]= cell.getStringCellValue();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 data [i-1][j]="";
				}
				System.out.println(data);
			}
		}
		wbook.close();
		return data;
	}
	

}
