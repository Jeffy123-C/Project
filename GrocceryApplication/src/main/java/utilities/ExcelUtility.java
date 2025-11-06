package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;//inbuilt class to read data from file
	static XSSFWorkbook wb;//java inbuilt class to read data from workbook
	static XSSFSheet sh;//inbuilt class used to read data from sheet
	public static String getStringData(int a,int b,String sheet) throws 
	IOException
	{
		f=new FileInputStream("C:\\Users\\Jeffy P Jerry\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx");
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);//method to get details from the sheet
		XSSFRow r =sh.getRow(a);//in builtclass used to read data from the row,getrow method to getvalues from row
		XSSFCell c = r.getCell(b);//class to read data from cell, getcell method to getdata from cell
		return c.getStringCellValue();//method used to get string value-getstringcellvalue
	}
	public static String getIntegerData(int a,int b,String sheet) throws IOException
	{
	f=new FileInputStream("C:\\Users\\Jeffy P Jerry\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx");
	wb=new XSSFWorkbook(f);
	sh=wb.getSheet(sheet);
	XSSFRow r=sh.getRow(a);
	XSSFCell c=r.getCell(b);
	int x=(int)c.getNumericCellValue();//method to get the numbers from cell,(int)is typecasting
	return String.valueOf(x);//typeconversion method to convert one datatype to string

	}
	public static String getFloatData(int a,int b,String sheet) throws IOException
	{
	f=new FileInputStream("C:\\Users\\Jeffy P Jerry\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx");
	wb=new XSSFWorkbook(f);
	sh=wb.getSheet(sheet);
	XSSFRow r=sh.getRow(a);
	XSSFCell c=r.getCell(b);
	float x=(float)c.getNumericCellValue();//method to get the numbers from cell,(float)is typecasting
	return String.valueOf(x);//typeconversion method to convert one datatype to string

	}
	}





