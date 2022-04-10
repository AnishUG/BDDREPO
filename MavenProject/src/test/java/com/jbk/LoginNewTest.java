package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginNewPage;

public class LoginNewTest {
	
	WebDriver driver;
	
	
	@BeforeClass 
	
	public void setup () {
		System.setProperty("Webdriver.chrome.driver", "chromerdriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
	}
	
	
	@Test (priority=2)
	
	public void logintestcases () {
		
		LoginNewPage lp = new LoginNewPage (driver);
		lp.LoginToApplication();
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		
	}
	
	@Test (priority=1)
	
	public void IncorrectUnametestcase () throws InterruptedException {
		
		LoginNewPage lp = new LoginNewPage (driver);
		lp.IncorrectUName();
		
	String	Emailerror = driver.findElement(By.id("email_error")).getText();
	
		Assert.assertEquals(Emailerror, "Please enter email as kiran@gmail.com");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		
	}
	
	@AfterClass
	
	public void closebrowser () {
		
		driver.close();
	}

}
