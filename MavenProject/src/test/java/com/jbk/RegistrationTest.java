package com.jbk;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest {
	
	WebDriver driver;
	
	@Test
	
	public void RegistrationTC () {
		
		
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		
		RegistrationPage RP = new RegistrationPage (driver);
		RP.NameValidation();
		
	Alert alert=	driver.switchTo().alert();
		
	alert.accept();
		
	}
	

}
