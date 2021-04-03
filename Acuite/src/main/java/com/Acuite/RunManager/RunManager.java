package com.Acuite.RunManager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Acuite.PageObjects.AcuiteHomePage;
import com.Acuite.PageObjects.AcuiteLoginPage;
import com.Acuite.Utilities.PropertiesFileReader;

import Utils_General.Utils_Generic;

public class RunManager {

		public WebDriver driver;
		
		PropertiesFileReader obj = new PropertiesFileReader();
		
		
		@Test
		public void TestRunner()
		{
			String Run_Flag;
			  try
			  {

			   String filepath = "D:\\Project\\Acuite\\RunManager.xlsx";
			   File file = new File(filepath);
			   FileInputStream isr = new FileInputStream(file);
			   
			  
			   
			   XSSFWorkbook wb = new XSSFWorkbook(isr);
			   XSSFSheet sheet = wb.getSheet("Sheet1");
			   
			   int rows = sheet.getLastRowNum();
			   
			   for(int r = 1; r <= rows; r++)
			   {
			   String action = sheet.getRow(r).getCell(0).getStringCellValue();
			   
			   switch(action)
			   {
			   case "TC_001":
			    Run_Flag = sheet.getRow(r).getCell(2).getStringCellValue().toString();
			    if (Run_Flag.equals("Y"))
		 	    {  			    	
			    	Properties properties =obj.getProperty();
					System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.get(properties.getProperty("browser.baseurl"));
					Thread.sleep(3000);
					driver.manage().window().maximize();
			    	
					 new AcuiteLoginPage(driver).LoginToHomePage();
					
			    }
			    
			    break;
			   case "TC_002":
				    Run_Flag = sheet.getRow(r).getCell(2).getStringCellValue().toString();
				    if (Run_Flag.equals("Y"))
				    {  			    	
				    	Properties properties =obj.getProperty();
						System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.get(properties.getProperty("browser.baseurl"));
						Thread.sleep(3000);
						driver.manage().window().maximize();
				    	
						 new AcuiteHomePage(driver).LogOut();
						
				    }

			   
			   default: System.out.println("Step undefined");
			   }
			   }
			  }
			  catch(Exception e)
			  {
			   System.out.println(e.getMessage());
			  }
			 }
			
		}
	
	
	
	
	
	
	
	
	

