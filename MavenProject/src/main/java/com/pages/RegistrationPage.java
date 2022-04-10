package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy (id="name")
	public WebElement name;
	
	@FindBy (id="mobile")
	public WebElement mobile;
	
	@FindBy (id="email")
	public WebElement email;
	
	@FindBy (id="password")
	public WebElement password;
	
	@FindBy (xpath="//button")
	public WebElement button;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void RegistrationSucessful () {
		
		name.sendKeys("Anish");
		mobile.sendKeys("8667784767");
		email.sendKeys("ndh@test.com");
		password.sendKeys("7676768");
		button.click();
		
		
	}
	
public void VerifyNameValidation () {
		
		name.sendKeys("");
		mobile.sendKeys("8667784767");
		email.sendKeys("ndh@test.com");
		password.sendKeys("7676768");
		button.click();
		
		
	}

public void VerifyMobileValidation () {
	
	name.sendKeys("Anish");
	mobile.sendKeys("");
	email.sendKeys("ndh@test.com");
	password.sendKeys("7676768");
	button.click();
	
	
}

public void VerifyEmailValidation () {
	
	name.sendKeys("Anish");
	mobile.sendKeys("8667784767");
	email.sendKeys("");
	password.sendKeys("7676768");
	button.click();
	
	
}

public void VerifyPWValidation () {
	
	name.sendKeys("Anish");
	mobile.sendKeys("8667784767");
	email.sendKeys("ndh@test.com");
	password.sendKeys("");
	button.click();
	
	
}

}
