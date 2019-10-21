package com.ak.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ak.base.BaseTest;

public class TestUtils extends BaseTest{
	
	public TestUtils() throws FileNotFoundException {
		
	}

	public static ExcelReader reader;
	
	public static Object[][] getTestData(String sheetName) {
		
		reader = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\TestData.xlsx");
		
		int rowCount = reader.getRowCount(sheetName);
		int colCount = reader.getColumnCount(sheetName);
		
		Object[][] data = new Object[rowCount-1][1];
		
		Hashtable<String , String> table=null;
		
		for(int row=2;row<=rowCount;row++) {
			table = new Hashtable<String,String>();
			for(int col=0;col<colCount;col++) {
				table.put(reader.getCellData(sheetName, col, 1), reader.getCellData(sheetName, col, row));
				data[row-2][0] = table;
			}
		}
		return data;
	}
	
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenShots/"+filename));
	}

}
