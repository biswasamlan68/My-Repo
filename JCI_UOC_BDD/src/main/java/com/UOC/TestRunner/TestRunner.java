package com.UOC.TestRunner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.ini4j.InvalidFileFormatException;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.InitializationError;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.DataProvider;


import com.UOC.Utils.SendMail;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.CucumberFeatureWrapper;
//import cucumber.api.testng.TestNGCucumberRunner;
/*import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;*/



/*@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
		"html:target/site/cucumber-pretty",
		"json:target/cucumber.json",
		"cucumberHooks.customReportListener"
		},*/
//monochrome = true,
@RunWith(Cucumber.class)
@CucumberOptions(features = "./features",
glue = {"com.UOC.StepDef","cucumberHooks"},
tags= {"@UATTesting"},plugin = {"pretty",
		"html:target/site/cucumber-pretty",
		"json:target/cucumber.json",
		"cucumberHooks.customReportListener"
		},
monochrome = true)







public class TestRunner {
	
	/*  @Before
	    public void beforeScenario(Scenario scenario) {
	        //log.error("Executing scenario "+scenario.getName());
	  }*/
	
	//public static WebDriver driver;
	private TestNGCucumberRunner testNGCucumberRunner;
	
/*	@BeforeClass(alwaysRun = true)
	public void setupClass() throws Exception {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}*/
		
/*	@Test(dataProvider = "features")
	public void Login(CucumberFeatureWrapper cucumberFeature)
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	*/
	
	
	
/*	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios() {
		 return super.scenarios();
		 }*/
	
/*	@BeforeClass(alwaysRun = true)  
    public void setUpClass() {  
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
  } */ 
	/*@Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
    public void scenario(PickleWrapper pickleevent, FeatureWrapper featureWrapper) throws Throwable {  
        testNGCucumberRunner.runScenario(pickleevent.getPickle());  
  } */ 
	
	
   
	/*@DataProvider  
  public Object[][] scenarios() {  
        return testNGCucumberRunner.provideScenarios();  
  }  
    */
    
/*    

    @AfterClass(alwaysRun = true)  
    public void tearDownClass() throws Exception {  
        testNGCucumberRunner.finish();  
	
    }
	
	*/
	/*public Object[][] features(){
				
		return testNGCucumberRunner.provideFeatures();
		
		
	}*/
	
	/*@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception
	{
		
		testNGCucumberRunner.finish();
	}
	*/
	
	
	  @Test//(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "features")
	  @Parameters(name = "features")
	    public void scenario(CucumberFeatureWrapper cucumberFeatureWrapper) throws Throwable {
	        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
	        //System.out.println(" Mail Sending");
	        
	  }

	  @DataProvider(name="features")
	  public Object[][] getFeatures()
	  {
	      if(testNGCucumberRunner == null){
	          testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	      }
	      return testNGCucumberRunner.provideFeatures();
	  }
	
	  @AfterClass
	  public static void sendmail() throws InvalidFileFormatException, IOException
	  {
		SendMail.Executemail();
		;
	  }
	
}