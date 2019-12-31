package com.qa.testlayer;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.base.CaptureFailureScreen;

public class CheckHomePage extends TestBase{
	
	public LoginPage objLoginPage;
	public HomePage objHomePage;
	public Boolean strMenuResult; 
	
	//TestBase objTestBase = new TestBase();
	
	
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException {

		
		TestBase.OpenWindow();

	}
	
	@Test(priority=11,enabled=false)
	public void VerifyLoginPage() throws InterruptedException
	{
		objLoginPage = new LoginPage();
		TestBase.extTest = TestBase.extReport.startTest("LoginToGIS");
		strMenuResult = objLoginPage.LoginToSite(TestBase.ObjProp.getProperty("username"),TestBase.ObjProp.getProperty("password"));
		/*
		if(strMenuResult)
			TestBase.AddResultToExtentReport(strMenuResult, "Logged in to GIS successfully");
		else
			TestBase.AddResultToExtentReport(strMenuResult, "Not logged in to GIS");
		*/
		 if(strMenuResult)
				TestBase.extTest.log(LogStatus.PASS, "Logged in to GIS successfully");
			else
				TestBase.extTest.log(LogStatus.FAIL, "Not logged in to GIS");
		TestBase.extReport.endTest(TestBase.extTest);
	}
	
  @Test(priority=12)
  public void VerifyManageRolePage() throws InterruptedException {
	  
	  objHomePage = new HomePage();
	  
	  TestBase.extTest = TestBase.extReport.startTest("Menu ManageRole");
	  strMenuResult = objHomePage.GotoManageRolePage();
	  if(strMenuResult)
			TestBase.extTest.log(LogStatus.PASS, "ManageRole link working");
		else
			TestBase.extTest.log(LogStatus.FAIL, "ManageRole link not found");
		TestBase.extReport.endTest(TestBase.extTest);
	}
  
	@Test(priority = 13,enabled=false)
	public void VerifyIntegrationLog() throws InterruptedException {

		TestBase.extTest = TestBase.extReport.startTest("Menu Integration Log");
		strMenuResult = objHomePage.GotoIntegrationLog();
		if (strMenuResult)
			TestBase.extTest
					.log(LogStatus.PASS, "Integration Log link working");
		else
			TestBase.extTest.log(LogStatus.FAIL,
					"Integration Log link not found");
		TestBase.extReport.endTest(TestBase.extTest);
	}
	
	
	@Test(priority = 14,enabled=false)
	public void VerifyGotoSystemEventLog() throws InterruptedException {

		TestBase.extTest = TestBase.extReport.startTest("System EventLog");
		strMenuResult = objHomePage.GotoSystemEventLog();
		if (strMenuResult)
			TestBase.extTest
					.log(LogStatus.PASS, "System event menu working");
		else
			TestBase.extTest.log(LogStatus.FAIL,"Integration Log link not found");
		TestBase.extReport.endTest(TestBase.extTest);
	}
	
  @AfterMethod
	public void teardown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			
			TestBase.extTest.log(LogStatus.PASS, result.getName(), "Pass");
			TestBase.extReport.endTest(TestBase.extTest);
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			String strScreenpath = CaptureFailureScreen.CaptureScreenShot(
					TestBase.ObjWebDriver, result.getName());
			TestBase.extTest.log(LogStatus.FAIL, result.getName(), strScreenpath);
			TestBase.extReport.endTest(TestBase.extTest);
		}else if (result.getStatus() == ITestResult.SKIP) {
			
			TestBase.extTest.log(LogStatus.SKIP, result.getName(), "Skip");
			TestBase.extReport.endTest(TestBase.extTest);
		}
	}

  @AfterClass
  public void AfterClass() {
	   TestBase.CloseWindow();
  }

}
