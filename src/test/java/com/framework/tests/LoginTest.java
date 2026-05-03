package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.WaitUtils;
import com.framework.utils.ScreenshotUtils;
import com.framework.config.ConfigReader;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;



public class LoginTest extends BaseTest {
	
	@BeforeMethod
	
	public void setup() {
		
		initialize();
	}
	
	@AfterMethod
	public void teardown() {
		
		stop();
	}
	
	@Test
	
	public void Login() {
	
		
		LoginPage log = new LoginPage(driver);
		log.get_username("standard_user");
		log.get_password("secret_sauce");
		log.login();
		
		WaitUtils wait = new WaitUtils(driver);
		wait.waitForElementVisible(driver,By.xpath("//div[text()=\"Swag Labs\"]"));	
		
		ScreenshotUtils.capture(driver, "HomePage");
		
		
	}
}


