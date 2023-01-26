package Utility_Classes;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Acti_Utility_Class {
	
	public static String getTestDat(int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Nikhil\\Desktop\\Testing Recorded Session and Notes\\All Recorded Lectures\\Jan-2023\\Day-69-10-01-2023\\DDF_TestNG.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("sheet1");
		
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
		
	}
}
