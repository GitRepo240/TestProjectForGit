/**
 * 
 */
package com.qa.stepdefinitionlayer;

import java.io.IOException;

import com.qa.base.TestBase;
import com.qa.pagelayer.LoginPage;
import com.qa.pagelayer.HomePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.base.BeforeSuiteAndTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Manohar
 *
 */
public class LoginStepDefine extends TestBase {

	public HomePage objGISHomePage;
	public LoginPage objGISLoginPage;
	ExtentTest logger;

	/*
	public LoginStepDefine()
	{
		super();
	}
	*/
		
	@Given("^GISLogin Open browser and start application$")
	public void gislogin_Open_browser_and_start_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		TestBase.OpenWindow();
		logger = TestBase.extReport.startTest("StartLoginScenario");
		//ObjDriver = objOpenBrowser.OpenWindow("Chrome");
	}

	@Given("^GISLogin Go to login page$")
	public void gislogin_Go_to_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objGISLoginPage  = new LoginPage();
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "Login page loaded");
	}

	@When("^GISLogin User enter valid (.*) and (.*)$")
	public void user_enter_valid_username_and_password(String strUsername, String strPassword) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objGISLoginPage.LoginToSite(strUsername, strPassword);
		//Or retrieve username & pwd using prop file.
		//objGISLoginPage.LoginToSite(ObjProp.getProperty("username"), ObjProp.getProperty("password"));
		logger.log(LogStatus.INFO, "Credentials entered");
	}

	@When("^GISLogin click on login button$")
	public void gislogin_click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		//objGISLoginPage.ClickOnLoginIn();
		System.out.println("ok");
		
	}

	@Then("^GISLogin Verify post login process$")
	public void gislogin_Verify_post_login_process() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objGISHomePage = new HomePage();
		objGISHomePage.ValidateHomePageTitle();
		logger.log(LogStatus.INFO, "Logged in successfully & Home page loaded");
	}

	@Then("^GISLogin Close browser$")
	public void gislogin_Close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//TestBase.CloseWinodw(TestBase.ObjWebDriver);
		logger.log(LogStatus.INFO, "EndLoginScenario");
		TestBase.extReport.endTest(logger);
		TestBase.CloseWindow();
	}

}
