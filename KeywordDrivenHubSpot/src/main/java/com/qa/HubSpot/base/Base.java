package com.qa.HubSpot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver init_driver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver_win32\\chromedriver.exe");
			if (prop.getProperty("headless").equalsIgnoreCase("Yes")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else
				driver = new ChromeDriver();

		}

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			if (prop.getProperty("headless").equalsIgnoreCase("Yes")) {
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else
				driver = new FirefoxDriver();
		}
		
		return driver;
	}

	public static Properties init_properties()
	{
		prop=new Properties();
		try {
			FileInputStream fileInput= new FileInputStream(".\\src\\main\\java\\com\\qa\\HubSpot\\config\\config.Properties");
			prop.load(fileInput);
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		return prop;
	}

}