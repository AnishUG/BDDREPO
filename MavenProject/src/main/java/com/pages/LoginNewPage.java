package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginNewPage {
	
	WebDriver driver;
	
	@FindBy (id="email")
	public WebElement email;
	
	@FindBy (id="password")
	public WebElement password;
	
	@FindBy (xpath="//button")
	public WebElement button;
	
	public LoginNewPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void LoginToApplication () {
		email.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		button.click();
	}
	
	public void IncorrectUName () {
		email.sendKeys("anish@gmail.com");
		password.sendKeys("123456");
		button.click();
		
	}

}
