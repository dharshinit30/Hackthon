package com.Bookshelf.driversetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class DriverSetup {

	static WebDriver driver;
	static String URL = "https://www.urbanladder.com/";
	public static String path_chrome = System.getProperty("user.dir") + "\\chromedriver.exe";
	public static String path_mozilla = System.getProperty("user.dir") + "\\geckodriver.exe";
	@BeforeTest     
	public static WebDriver getDriver(String browser){

		DesiredCapabilities cap = new DesiredCapabilities();

		//for chrome browser
		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();

			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);

		}

		//for mozilla firefox browser
		else if(browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("Mozilla"))
		{

			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);

		}



		String hubURL = "http://localhost:4444/wd/hub";

		
		try {
			
			driver = new RemoteWebDriver(new URL(hubURL),cap);
			driver.navigate().to(URL);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
