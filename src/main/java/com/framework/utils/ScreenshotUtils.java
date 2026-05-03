package com.framework.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	
	public static void capture(WebDriver driver , String filename) {
		
		try
		{
		
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("Screenshots/" + filename + ".png"));
		
		}
		
		catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
	}
	
	

}
