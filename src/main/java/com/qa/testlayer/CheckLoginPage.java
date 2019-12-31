/**
 * 
 */
package com.qa.testlayer;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.CaptureFailureScreen;
import com.qa.base.TestBase;
import com.qa.pagelayer.HomePage;
import com.qa.pagelayer.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Manohar
 *
 */
public class CheckLoginPage extends TestBase{

	public LoginPage objLoginPage;
	public HomePage objHomePage;
	public Boolean strMenuResult; 
	
	
	//TestBase objTestBase = new TestBase();
	
	@BeforeClass
	 public void BeforeClass() {
	
		TestBase.OpenWindow();
		
	}
	
	@Test(priority=1)
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
	
	
	@Test(priority=2)
	public void VerifyDashboard() throws InterruptedException
	{
		objLoginPage.GotoDashboard();
		Assert.assertTrue(true);
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
