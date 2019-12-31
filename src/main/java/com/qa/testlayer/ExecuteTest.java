/**
 * 
 */
package com.qa.testlayer;

import org.testng.TestNG;

/**
 * @author Manohar
 *
 */
public class ExecuteTest {

	/**
	 * @param args
	 */
	
	static TestNG testNG;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		testNG = new TestNG();
		
		Class[] testClasses = {CheckContactPage.class,CheckSearchPage.class};
		
		
		testNG.setTestClasses(testClasses);
		testNG.run();
		
	}

}
