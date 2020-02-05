package com.enhamzed.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	public void createNewSheet()
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		FileOutputStream out;
		try
		{
			out=new FileOutputStream("user test data create.xlsx");
			workbook.write(out);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName)
	{
		int count=0;
		try
		{
			FileInputStream fis = new FileInputStream("user test data create.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet(sheetName);
		    count=sh.getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public void createNewSheet(String sheetName)
	{
		try
		{
			FileInputStream fis=new FileInputStream("user test data create.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.createSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getDataFromExcel(String sheetName, int rowNum, int colNum)
	{
		String Data=null;
		try
		{
			FileInputStream fis=new FileInputStream("user test data create.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row r=sh.getRow(rowNum);
			Cell c=r.getCell(colNum);
			Data=c.getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Data;
		
	}
	
	public void setExcelDataToAnEmptyRow(String sheetName,int rowNum, int colNum, String data)
	{
		try
		{
			FileInputStream fis=new FileInputStream("user test data create.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row r=sh.createRow(rowNum);
			Cell c=r.createCell(colNum);
			c.setCellValue(data);
			
			FileOutputStream fos=new FileOutputStream("user test data create.xlsx");
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void setIntegerDataToAnEmptyRow(String sheetName,int rowNum,int colNum, int data)
	{
		try
		{
		FileInputStream fis=new FileInputStream("user test data create.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.getRow(rowNum);
		Cell c=r.createCell(colNum);
		c.setCellValue(data);
		
		
		FileOutputStream fos=new FileOutputStream("user test data create.xlsx");
		wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void setExcelData(String sheetName,int rowNum,int colNum,String data)
	{
		try
		{
			FileInputStream fis=new FileInputStream("user test data create.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			Row r=sh.getRow(rowNum);
			Cell c=r.createCell(colNum);
			c.setCellValue(data);
			
			FileOutputStream fos=new FileOutputStream("user test data create.xlsx");
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
