package com.framework.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.config.ConfigReader;


public class WaitUtils {
	
	WebDriver driver; 
	ConfigReader config = new ConfigReader();

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }
	public void waitForElementVisible(WebDriver driver , By locator) 
		
	{
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(config.getexplicit()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}

