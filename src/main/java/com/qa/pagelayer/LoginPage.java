/**
 * 
 */
package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

/**
 * @author Manohar
 *
 */
public class LoginPage {

	 //private static String PAGE_URL="https://gis-test1.intertek.com/";
	//WebDriver objDriver = GISOpenBrowser.driver;
	 @FindBy(id = "UserName")
	 private WebElement eUsername;
	   
	 @FindBy(id = "Password")
	 private WebElement ePassword;
	 
	 @FindBy(className = "btn btn-blue btn-lg")
	 private WebElement eLoginButton;
	 
	 @FindBy(tagName = "button")
	 private WebElement eLoginButton2;
	
	 @FindBy(linkText = "Home")
	 private WebElement eHome;
	 
	 @FindBy(linkText = "Search")
	 private WebElement eSearch;
	   
	 WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
	 
	 public LoginPage(){
		 System.out.println("Login page constructor");
	       //Initialize Elements
	     PageFactory.initElements(TestBase.ObjWebDriver, this);
		 //System.out.println("inside constructor");
	   }

	 
	 
	 
	 public void setUsername(String strUsername)
	   {
		 eUsername.clear();
		 eUsername.sendKeys(strUsername);
	   }
	   public void setPassword(String strPassword)
	   {
		   ePassword.clear();
		   ePassword.sendKeys(strPassword);
	   }
	   public void ClickOnLoginIn()
	   {
		   eLoginButton2.click();
	   }
	   public boolean isTestPass(String strExpectedTitle)
	   {
		   //System.out.println("mainpage " +this.driver.getTitle());
		   //System.out.println("innserpage " +objdriver.getTitle());
		   return TestBase.ObjWebDriver.getTitle().toString().contains(strExpectedTitle); 
	   }
	   
	   public boolean LoginToSite(String strUsername,String strPassword) throws InterruptedException 
	   {
		   	//WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
		   	this.setUsername(strUsername);
	 		this.setPassword(strPassword);
	 		
	 		this.ClickOnLoginIn();
	 		Thread.sleep(10000);
	 		
	 		String strExpectedTitle="Planner Home";
	 		objWait.until(ExpectedConditions.elementToBeClickable(eSearch));
	 		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
	 		
	 		if(TestBase.ObjWebDriver.getTitle().contentEquals(strExpectedTitle))
	 			return true;
	 		else
	 			return false;
	   }	
	 
	   
	   public void GotoDashboard() throws InterruptedException
	   {	
		   objWait.until(ExpectedConditions.elementToBeClickable(eSearch));
		   objWait.until(ExpectedConditions.elementToBeClickable(eHome)).click();
		   
		   String strExpectedTitle="To-do-list";
		   objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
	   }
	 
	   
	   
	   public void LogOutFromSite() throws InterruptedException
	   {	
		   //this.ClickOnSignOff();
		   Thread.sleep(5000);
		   //this.ClickOnHome();
		   Thread.sleep(5000);
	   }
	 
}
