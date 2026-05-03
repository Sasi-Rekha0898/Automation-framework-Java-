package com.framework.pages;
import org.openqa.selenium.*;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By user_name = By.id("user-name");
	By pass_word = By.id("password");
	By submit = By.id("login-button");
	
	public void get_username(String user) {
		
		driver.findElement(user_name).sendKeys(user);
	}
	
	public void get_password(String pwd) {
		
		driver.findElement(pass_word).sendKeys(pwd);
	}
	
	public void login() {
		
		driver.findElement(submit).click();
	}

}
