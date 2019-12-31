/**
 * 
 */
package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Manohar
 *
 */
public class ReadWriteExcelFile {
	public String strURL;
	public WebDriver driver; 
	
	@BeforeTest
	public void OpenBrowser() throws Exception {
		
		///--for chrome browser
		//System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		
	}
	
	@AfterTest
	public void CloseBrowser() throws Exception {
		
		//Thread.sleep(10000);
		//driver.quit();
	
	}
	
	@Test(enabled=true)
	public void TestReadExcel(String filePath,String fileName,String sheetName) throws IOException{
		 
		    //Create a object of File class to open xlsx file
		    File file =    new File(filePath+"\\"+fileName);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    
		    Workbook TestDataReadWrite = null;
		    //Find the file extension by spliting file name in substring and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    //Check condition if the file is xlsx file
		
		    if(fileExtensionName.equals(".xlsx"))
		    {
		    	//If it is xlsx file then create object of XSSFWorkbook class
		    	TestDataReadWrite = new XSSFWorkbook(inputStream);
		    }
		    //Check condition if the file is xls file
		    else if(fileExtensionName.equals(".xls"))
		    {
		        //If it is xls file then create object of XSSFWorkbook class
		    	TestDataReadWrite = new HSSFWorkbook(inputStream);
		    }
		 
		    //Read sheet inside the workbook by its name
		    Sheet guru99Sheet = TestDataReadWrite.getSheet(sheetName);
		    //Find number of rows in excel file
		    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		    //Create a loop over all the rows of excel file to read it
		 
		    for (int i = 0; i < rowCount+1; i++) {
		        Row row = guru99Sheet.getRow(i);
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            //Print excel data in console
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        }
		        System.out.println();
		    }
	    }
	
	public Sheet ReadExcel(String filePath,String fileName,String sheetName) throws IOException{
		 
	    //Create a object of File class to open xlsx file
	    File file =    new File(filePath+"\\"+fileName);
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    
	    Workbook TestDataReadWrite = null;
	    //Find the file extension by spliting file name in substring and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    //Check condition if the file is xlsx file
	
	    if(fileExtensionName.equals(".xlsx"))
	    {
	    	//If it is xlsx file then create object of XSSFWorkbook class
	    	TestDataReadWrite = new XSSFWorkbook(inputStream);
	    }
	    //Check condition if the file is xls file
	    else if(fileExtensionName.equals(".xls"))
	    {
	        //If it is xls file then create object of XSSFWorkbook class
	    	TestDataReadWrite = new HSSFWorkbook(inputStream);
	    }
	 
	    //Read sheet inside the workbook by its name
	    Sheet ExcelSheet = TestDataReadWrite.getSheet(sheetName);
	    //Find number of rows in excel file
	    //int rowCount = ExcelSheet.getLastRowNum()-ExcelSheet.getFirstRowNum();
	    //Create a loop over all the rows of excel file to read it
	    //TestDataReadWrite.close();
	    return ExcelSheet;
    }
	
	public void TestWriteExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException
	{
		 
        //Create a object of File class to open xlsx file
 
        File file =    new File(filePath+"\\"+fileName);
        //Create an object of FileInputStream class to read excel file
 
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru99Workbook = null;
 
        //Find the file extension by spliting file name in substing and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        //Check condition if the file is xlsx file
        if(fileExtensionName.equals(".xlsx")){
        //If it is xlsx file then create object of XSSFWorkbook class
        guru99Workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if(fileExtensionName.equals(".xls")){
            //If it is xls file then create object of XSSFWorkbook class
            guru99Workbook = new HSSFWorkbook(inputStream);
        }
 
         
	    //Read excel sheet by sheet name    
	    Sheet sheet = guru99Workbook.getSheet(sheetName);
	 
	    //Get the current count of rows in excel file
	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    //Get the first row from the sheet
	    Row row = sheet.getRow(0);
	    //Create a new row and append it at last of sheet
	    Row newRow = sheet.createRow(rowCount+1);
	    //Create a loop over the cell of newly created Row
	 
	    for(int j = 0; j < row.getLastCellNum(); j++){
	        //Fill data in row
	        Cell cell = newRow.createCell(j);
	        cell.setCellValue(dataToWrite[j]);
	    }
	 
	    //Close input stream
	    inputStream.close();
	    //Create an object of FileOutputStream class to create write data in excel file
	    FileOutputStream outputStream = new FileOutputStream(file);
	    //write data in the excel file
	    guru99Workbook.write(outputStream);
	    //close output stream
	    outputStream.close();
 
    }
 
	//Main function is calling readExcel function to read data from excel file
	 
    public static void main(String...strings) throws IOException{
 
	    //Create a object of ReadGuru99ExcelFile class
    	ReadWriteExcelFile objExcelFile = new ReadWriteExcelFile();
	    //Prepare the path of excel file
	    String filePath = System.getProperty("user.dir")+"\\ResourcesN\\DataN";
	    
	    String[] valueToWrite = {"Mr. E","Noida"};
	    objExcelFile.TestWriteExcel(filePath,"TestDataReadWrite.xlsx","WriteSheet",valueToWrite);
	    
	    if(!filePath.isEmpty())
	    {
		    //Call read file method of the class to read data
		    objExcelFile.TestReadExcel(filePath,"TestDataReadWrite.xlsx","ReadSheet");
	    }
	    
	    
    }
}
