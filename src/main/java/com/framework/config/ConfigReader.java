package com.framework.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader()
	{
	
		try
		{
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
		
	public String geturl() {
		return prop.getProperty("url");
	}	
	public int getimplicit() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}
	public int getexplicit() {
		return Integer.parseInt(prop.getProperty("explicitWait"));
	}

}
