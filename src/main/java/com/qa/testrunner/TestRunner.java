/**
 * 
 */
package com.qa.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Manohar
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
			// features = {"src/test/resources/"},
			// tags =
			// {"@LoginWithMercury","@LoginWithTestuser","~@LoginWithScenarioOutline","~@LoginWithDatatable"},
			features = {"src/test/java/com/qa/featurelayer"},
			//tags = {"@LoginToGIS"}, //And condition : both the tag will be executed.
			tags = {"@LoginToGIS,@LoadManageRolePage"}, //OR condition : any one of tag will be executed.
			glue = {"com/qa/stepdefinitionlayer"},
					
			//strict = true,
			monochrome = true,
			//dryRun = false,
			plugin = {
					"pretty","html:target/cucumber-pretty",
					"json:target/Cucumber.json",
					"pretty:target/CucumberPretty.txt"
					//"usage:target/CucumberUsage.json",
					//"junit:Reports/CucumberResult.xml",
					
			
			}
 )
public class TestRunner {

	//@Test(priority = 0)
	public static void main()
	{
		System.out.println("Test Runner Loaded");
	}

}
