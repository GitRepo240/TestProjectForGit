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
public class CheckSearchPage {

	
	
	@BeforeTest
	public void BeforeTest() throws InterruptedException {

		
		//TestBase.OpenWindow();

		System.out.println("BeforeTest Search ");
		
		
	}
	
	
	
	 @Test(priority=1)
	  public void VerifySearch() {
		  
		  
		  
		 System.out.println(" VerifySearch method");
	  }
	
	 @Test(priority=2)
	  public void VerifySearchNew() {
		  
		  
		  
		 System.out.println(" VerifySearchnew method");
	  }
	
	
	
	 @AfterTest
	  public void afterTest() {
		  
		  
		  
		 System.out.println("AfterTest Search ");
	  }
	
	
	
}
