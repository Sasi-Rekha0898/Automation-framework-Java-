package com.framework.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.framework.config.ConfigReader;
public class BaseTest {
	
	
	protected WebDriver driver ;
	ConfigReader config = new ConfigReader(); 
	
	public void initialize()
	
	{
		if (config.getBrowser().equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getimplicit()));
		driver.get(config.geturl());
	}
	
	public void stop()
	{
		driver.quit();
	}
	
	

}
