package com.jbk;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest {

	WebDriver driver;

	@BeforeClass

	public void setup() {
		System.setProperty("Webdriver.chrome.driver", "chromerdriver.exe");

		driver = new ChromeDriver();

		driver.get(
				"file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/register.html");

	}
@Test (priority=5)
	public void RegTestcases() throws Exception {

		RegistrationPage rt = new RegistrationPage(driver);
		rt.RegistrationSucessful();

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

@Test (priority=1)

public void CheckNameValidation () throws Exception {
	
	RegistrationPage rt= new RegistrationPage(driver);
	rt.VerifyNameValidation();
	
	String NameError = driver.findElement(By.id("name_error")).getText();
	
	Assert.assertEquals(NameError, "Please enter Name.");
	
	Thread.sleep(3000);
	
	driver.navigate().refresh();
	
	
	
	
}

@Test (priority=2)

public void CheckMobileValidation () throws Exception {
	
	RegistrationPage rt= new RegistrationPage(driver);
	rt.VerifyMobileValidation();
	
	String MobileError = driver.findElement(By.id("mobile_error")).getText();
	
	Assert.assertEquals(MobileError, "Please enter Mobile.");
	
	Thread.sleep(3000);
	driver.navigate().refresh();
	
}

@Test (priority=3)

public void CheckEmailValidation () throws Exception {
	
	RegistrationPage rt= new RegistrationPage(driver);
	rt.VerifyEmailValidation();
	
	String EmailError = driver.findElement(By.id("email_error")).getText();
	
	Assert.assertEquals(EmailError, "Please enter Mobile.");
	Thread.sleep(3000);
	driver.navigate().refresh();
	
}

@Test (priority=4)

public void CheckPWlValidation () throws Exception {
	
	RegistrationPage rt= new RegistrationPage(driver);
	rt.VerifyPWValidation();
	
	String PWError = driver.findElement(By.id("password_error")).getText();
	
	Assert.assertEquals(PWError, "Please enter Mobile.");
	Thread.sleep(3000);
	driver.navigate().refresh();
	
}

	
	@AfterClass
	
	public void closebrowser () {
		driver.close();
	}

}
