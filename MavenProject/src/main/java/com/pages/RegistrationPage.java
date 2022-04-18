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
		PageFactory.initElements(driver, this);
	}

	public void createuser () {
		
		name.sendKeys("Anish");
		mobile.sendKeys("8676767");
		email.sendKeys("Andy@gmail.com");
		password.sendKeys("64vv7");
		button.click();
	}

}
