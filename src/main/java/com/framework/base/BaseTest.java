package com.framework.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.framework.config.ConfigReader;
public class BaseTest {
	
	
	protected WebDriver driver ;
	ConfigReader config = new ConfigReader(); 
	
	public void initialize()
	
	{
		if (config.getBrowser().equalsIgnoreCase("Chrome"))
		{	
			ChromeOptions options = new ChromeOptions();

	        options.addArguments("--headless=new");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--remote-allow-origins=*");
	        options.addArguments("--disable-gpu");

	        driver = new ChromeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getimplicit()));
		driver.get(config.geturl());
	}
	
	public void stop()
	{
		driver.quit();
	}
	
	

}
