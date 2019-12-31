/**
 * 
 */
package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Manohar
 *
 */
public class TestBase {

	//Global Variables.
	public static WebDriver ObjWebDriver;
	public static Properties ObjProp;
	public static ExtentReports extReport;
	public static ExtentTest extTest;
	
	
	
	
	public TestBase() 
	{
		
		System.out.println("Test base constructor");
		try {
			ExtentReportStart();
			LoadPropertiesData();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LoadPropertiesData() throws IOException
	{
		System.out.println("Load Prop");
		ObjProp = new Properties();
		try {
			String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\util\\config.properties";
			FileInputStream ObjFile = new FileInputStream(filepath);
			ObjProp.load(ObjFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void ExtentReportStart() {

		System.out.println("Report Started");
		String filepath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\Reports\\TestResult.html";
		System.out.println("file path: " + System.getProperty("user.dir"));
		System.out.println(filepath);
		extReport = new ExtentReports(filepath);
	}
	
	public static void AddResultToExtentReport(Boolean strMenuResult, String MessageDetails)
	{
		if(strMenuResult)
			TestBase.extTest.log(LogStatus.PASS, MessageDetails);
		else
			TestBase.extTest.log(LogStatus.FAIL, MessageDetails);
	}
	
	
	public static void EndExtentResult() {

		extReport.flush();
		String filepath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\Reports\\TestResult.html";
		ObjWebDriver.get(filepath);
	}
	public static void OpenWindow()
	{
		System.out.println("open Browser");
		String browser = ObjProp.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Firefox"))
		{
			TestBase.ObjWebDriver = new FirefoxDriver();
			System.out.println("Before Test Firefox : " + Thread.currentThread().getId());	 
		}
		else if (browser.equalsIgnoreCase("Chrome"))
		{
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			//To Turns off multiple download warning
			prefs.put("profile.default_content_settings.popups", 0);
			//Turns off download prompt
			prefs.put("download.prompt_for_download", false);
			prefs.put("credentials_enable_service", false);
			//To Stop Save password propmts
			prefs.put("password_manager_enabled", false);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-extensions");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
			
			TestBase.ObjWebDriver = new ChromeDriver(options);
			System.out.println("OPen Chrome BRW GC ThreadID: " + Thread.currentThread().getId());
			
		}
		
		TestBase.ObjWebDriver.manage().window().maximize();
		TestBase.ObjWebDriver.manage().deleteAllCookies();
		TestBase.ObjWebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//ObjRepository = new RepositoryParser("object.properties");
		
		TestBase.ObjWebDriver.get(ObjProp.getProperty("stageurl"));
		WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
		String strExpectedTitle="Intertek User Login";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		
		//WebElement html = driver.findElement(By.tagName("html"));
		//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	}
	
	
	public static void CloseWindow()
	{
		EndExtentResult();
		
		if (TestBase.ObjWebDriver!=null)
		{
			TestBase.ObjWebDriver.close();
			TestBase.ObjWebDriver.quit();
		}
		
	 }

	
	
}
