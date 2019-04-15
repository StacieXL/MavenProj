package com.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.TestBase.TestBase;

public class TestUtil extends TestBase {  //inherits so that value cant be changed in TestBase class
	public static long PAGELOADOUTTIME =20; 
	public static long IMPLICITYWAIT =30; 

	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_PATH = "C:\\Users\\Stacie\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\TestData\\Service.xlsx";

	public static Object [][] getTestData( String sheetName) throws Exception{  //Object is a class & also a super class
		
			FileInputStream file = null;
			try {
				file = new FileInputStream (TESTDATA_PATH);

				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  
		sheet =  book.getSheet(sheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0; i<sheet.getLastRowNum(); i++) {
			for( int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
				
				data [i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}





}
