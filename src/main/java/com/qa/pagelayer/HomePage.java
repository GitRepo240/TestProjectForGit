/**
 * 
 */
package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

/**
 * @author Manohar
 * 
 */
public class HomePage {

	@FindBy(linkText = "Administration")
	private WebElement eAdministration;

	// WebDriverWait objWait;

	//Actions objAction = new Actions(TestBase.ObjWebDriver);
	WebDriverWait objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);

	public HomePage() {
		System.out.println("Home page constructor");
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(TestBase.ObjWebDriver, this);
	}

	// @FindBy(linkText = "Manage Role")
	// private WebElement eManageRole;

	public boolean GotoManageRolePage() throws InterruptedException {
		
		//objWait = new WebDriverWait(TestBase.ObjWebDriver, 20);
		// this.setUsername(strUsername);
		// WebElement eAdministration =
		// GISOpenBrowser.driver.findElement(By.linkText("Administration"));
		Thread.sleep(5000);
		 Actions objAction = new Actions(TestBase.ObjWebDriver);
		objWait.until(ExpectedConditions.elementToBeClickable(eAdministration));
		objAction.moveToElement(eAdministration).build().perform();
		//TestBase.ObjWebDriver.findElement(By.linkText("Manage Role")).click();
		
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.partialLinkText("Role")))).click();
		String strExpectedTitle = "Role List";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		
		if(TestBase.ObjWebDriver.getTitle().contentEquals(strExpectedTitle))
 			return true;
 		else
 			return false;
	}
	
	public boolean GotoIntegrationLog() throws InterruptedException {
		
		Thread.sleep(3000);
		Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eAdministration).build().perform();
		//TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")).click();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")))).click();
		String strExpectedTitle = "Integration Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		if(TestBase.ObjWebDriver.getTitle().contentEquals(strExpectedTitle))
 			return true;
 		else
 			return false;
	}

	public boolean GotoSystemEventLog() throws InterruptedException {
		
		Thread.sleep(3000);
		Actions objAction = new Actions(TestBase.ObjWebDriver);
		objAction.moveToElement(eAdministration).build().perform();
		//TestBase.ObjWebDriver.findElement(By.linkText("Integration Log")).click();
		objWait.until(ExpectedConditions.elementToBeClickable(TestBase.ObjWebDriver.findElement(By.linkText("System Event Log")))).click();
		String strExpectedTitle = "System Event Log";
		objWait.until(ExpectedConditions.titleContains(strExpectedTitle));
		if(TestBase.ObjWebDriver.getTitle().contentEquals(strExpectedTitle))
 			return true;
 		else
 			return false;
	}
	


	
	
	public boolean isTestPass(String strExpectedTitle) {
		// System.out.println("mainpage " +this.driver.getTitle());
		// System.out.println("innserpage " +objdriver.getTitle());
		return TestBase.ObjWebDriver.getTitle().toString()
				.contains(strExpectedTitle);
	}

	public void ValidateHomePageTitle() throws InterruptedException {

		String strExpectedTitle = "To-do-list";

		if (this.isTestPass(strExpectedTitle)) {
			System.out.println("Logged in successfully & user is on home page");
			// objGISLoginPage.ClickOnSignOff();
			Thread.sleep(9000);
		} else {
			System.out.println("Log-in is not successfull.");
		}

	}

	public void LogOutFromSite() throws InterruptedException {
		// this.ClickOnSignOff();
		Thread.sleep(5000);
		// this.ClickOnHome();
		// Thread.sleep(5000);
	}

}
