package com.jbk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest {
	
	WebDriver driver;
	
	@Test
	
	public void Regtestcases () {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/register.html");
		
		RegistrationPage RP = new RegistrationPage (driver);
		
		RP.createuser();
		
		
		
	}

}
