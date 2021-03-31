package com.UOC.StepDef;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.UOC.PageObjects.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;





public class Login
{


	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable {
		LoginPage obj1= new LoginPage(5);
		System.out.println(obj1.num);
	}

	
	@When("^Enter correct User Name and Password$")
	public void enter_UserName_Password() throws Throwable {
		LoginPage obj3= new LoginPage(10);
		System.out.println(obj3.num);
		
	}
	
	@And("^Hit Login button$")
	public void hit_Login() throws Throwable {
		LoginPage obj3= new LoginPage(15);
		System.out.println(obj3.num);
		
	}

	@Then("^Validate title$")
	public void validate_Title() throws Throwable {
		LoginPage obj4= new LoginPage(20);
		System.out.println(obj4.num);
		
	}
	
	
}
