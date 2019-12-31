/**
 * 
 */
package com.qa.stepdefinitionlayer;

import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.qa.pagelayer.ManageRolePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Manohar
 *
 */
public class HomeStepDefine extends TestBase{

	public LoginPage objLoginPage;
	public HomePage objHomePage;
	public ManageRolePage objManageRolePage;
	ExtentTest logger;
	
	@Given("^Open browser and start application with login page$")
	public void open_browser_and_start_application_with_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		TestBase.OpenWindow();
		objLoginPage = new LoginPage();
		logger = TestBase.extReport.startTest("StartHomePageScenario");
	}

	@Given("^Logged in successfully with valid (.*) and (.*) and go to home page$")
	public void logged_in_successfully_with_valid_credentials_and_go_to_home_page(String strUsername, String strPassword) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		objLoginPage.LoginToSite(strUsername,strPassword);
		objHomePage = new HomePage();
		logger.log(LogStatus.INFO, "home Page page loaded");
	}

	@When("^User click on administration menu and manage role sub menu home page is loaded$")
	public void user_click_on_administration_menu_and_manage_role_sub_menu_home_page_is_loaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objHomePage.GotoManageRolePage();
		logger.log(LogStatus.INFO, "ManageRole page loaded");
	}

	@Then("^Validate manage role page title$")
	public void validate_manage_role_page_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objManageRolePage = new ManageRolePage();
		objManageRolePage.ValidateManageRolePageTitle();
		
	}

	@Then("^ManageRole Close browser$")
	public void managerole_Close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logger.log(LogStatus.INFO, "EndHomePageScenario");
		TestBase.extReport.endTest(logger);
	    TestBase.CloseWindow();
	}


	
}
