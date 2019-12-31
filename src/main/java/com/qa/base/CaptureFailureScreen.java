/**
 * 
 */
package com.qa.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Manohar
 *
 */
public class CaptureFailureScreen {
	
	
	public static String CaptureScreenShot (WebDriver driver,String Screenshotname)
	{
		try{
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest =System.getProperty("user.dir")+"\\src\\test\\resources\\"+Screenshotname+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
			return dest;
			
		}
		catch (Exception e)
		{
			return e.getMessage();
			
		}
		
	}
}
