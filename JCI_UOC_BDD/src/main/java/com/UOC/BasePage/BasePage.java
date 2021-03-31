package com.UOC.BasePage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.UOC.ReadResourceFiles.ConfigFileReader;

public class BasePage {

		private static BasePage BasePage_instance;
	    public static WebDriver driver;
	    public static WebDriverWait wait;
	    public static  Test test;
	    public static Properties prop;
	    public static ConfigFileReader configFileReader;
	    
	    //Constructor
	    @SuppressWarnings("static-access")
		private BasePage(WebDriver driver, WebDriverWait wait ,Test test,ConfigFileReader configFileReader){
	        this.driver = driver;
	        this.wait = wait;
	        this.test=  test;
	        this.configFileReader=configFileReader;
	    }    
	    
	    public BasePage reusableMethod(WebDriver driver, WebDriverWait wait ,Test test,ConfigFileReader configFileReader)
	    {
			
	    	BasePage_instance = new BasePage(driver, wait, test, configFileReader);
	    	return BasePage_instance;
	    	
	    }
	    
	 /*UOC Portal :
Endpoint: https://obuoc-stg.hostcountry.qa
Credentials :
1.usera@hostcountry.onmicrosoft.com
	
2.userb@hostcountry.onmicrosoft.com
Unistad@2022*/
	
	
	
}
