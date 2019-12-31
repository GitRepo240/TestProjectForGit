/**
 * 
 */
package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Manohar
 * 
 */
public class BeforeSuiteAndTest {

	// public static WebDriver driver;
	public static ExtentReports Report;
	ExtentTest logger;

	//@BeforeTest
	@Test(priority = 0)
	public void StartStepBeforeTest() {
		ExtentReportStart();

	}

	public static void ExtentReportStart() {

		String filepath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Reports\\TestResult.html";
		System.out.println("file path: " + filepath);
		Report = new ExtentReports(filepath);

	}

	@Test(priority = 1)
	public void FirstTestcase() {
		System.out.println("First Method");
		logger = Report.startTest("TestFirstTestcase");
		logger.log(LogStatus.INFO, "First test case 11");
		logger.log(LogStatus.PASS, "title verified");
		Report.endTest(logger);
	}

	public void EndExtentResult() {

		Report.flush();
		String filepath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Reports\\TestResult.html";
		// driver.get(filepath);
	}

	//@AfterTest
	@Test(priority = 2)
	public void EndStepAfterTest() {
		EndExtentResult();
		// CloseWinodw();
	}

}
