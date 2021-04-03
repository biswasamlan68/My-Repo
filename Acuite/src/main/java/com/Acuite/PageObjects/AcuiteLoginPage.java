package com.Acuite.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Acuite.Utilities.PropertiesFileReader;

import Utils_General.Utils_Generic;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AcuiteLoginPage {
	
	WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();
	
    

	public AcuiteLoginPage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (how=How.XPATH, using="//input[@type='text']")
	public static WebElement username;
	@FindBy (how=How.XPATH, using="//input[@type='password']")
	public static WebElement password;
	@FindBy(how=How.XPATH, using="//button[@type='button']" )
	public static WebElement loginbutton;
	
	
	
	
	public void LoginToHomePage() throws InterruptedException, IOException, BiffException
	{
		 FileInputStream fis = new FileInputStream("D:\\Project\\Acuite\\Test Data.xls");
		 Workbook wb = Workbook.getWorkbook(fis);
		 Sheet sh = wb.getSheet("Sheet1");
		 String username_input = sh.getCell(0,1).getContents();
		 username.sendKeys(username_input);
		 Thread.sleep(2000);
		 String password_input = sh.getCell(1,1).getContents();
		  password.sendKeys(password_input);
		 Thread.sleep(2000);
		 loginbutton.click();
		 Thread.sleep(2000);
		 Utils_Generic.TakeScreenshot(driver);
			
	}
	
	


	
}
