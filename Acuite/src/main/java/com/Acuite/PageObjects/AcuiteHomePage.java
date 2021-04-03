package com.Acuite.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Acuite.Utilities.PropertiesFileReader;

import Utils_General.Utils_Generic;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AcuiteHomePage {

	WebDriver driver;
   
	
    

	public AcuiteHomePage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (how=How.XPATH, using="//button[@type='button'and @class='webix_button webix_img_btn']")
	public static WebElement logoutbutton;
	
	
	
	
	public void LogOut() throws InterruptedException, IOException, BiffException
	{
		
		new AcuiteLoginPage(driver).LoginToHomePage();
		logoutbutton.click();
		Utils_Generic.TakeScreenshot(driver);
	}
	
	
	
}
