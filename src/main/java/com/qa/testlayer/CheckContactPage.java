/**
 * 
 */
package com.qa.testlayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

/**
 * @author Manohar
 *
 */
public class CheckContactPage {

	
	
	@BeforeTest
	public void BeforeTest() throws InterruptedException {

		
		//TestBase.OpenWindow();

		System.out.println(" BeforeTest  Contact ");
		
		
	}
	
	
	
	 @Test(priority=1)
	  public void VerifyContact() {
		  
		  
		  
		 System.out.println(" VerifyContact method");
	  }
	
	 @Test(priority=2)
	  public void VerifyContactnew() {
		  
		  
		  
		 System.out.println(" VerifyContactnew method");
	  }
	
	
	
	
	 @AfterTest
	  public void afterTest() {
		  
		  
		  
		 System.out.println(" AfterTest Contact ");
	  }
}
