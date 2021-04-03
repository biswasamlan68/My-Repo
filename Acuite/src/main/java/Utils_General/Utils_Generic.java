package Utils_General;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Acuite.PageObjects.AcuiteLoginPage;
import com.Acuite.Utilities.PropertiesFileReader;

public class Utils_Generic {
	
	public static void TakeScreenshot(WebDriver driver) throws IOException { 
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(scrFile, new File("D:\\Project\\Acuite\\Screenshots\\" + timestamp() + ".jpeg"));
		
	  
	}

	public static String timestamp() { // TODO Auto-generated method stub return
		 return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()); 
		 }




}
