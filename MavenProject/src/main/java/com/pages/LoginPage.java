package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver lpdriver;
	
	public LoginPage(WebDriver driver) {
		this.lpdriver= driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getUname() {
		return lpdriver.findElement(By.id("email"));
		
	}
	
	public WebElement getPassword() {
		return lpdriver.findElement(By.id("password"));
	}
	
	public WebElement getButtonClicked() {
		
	return	lpdriver.findElement(By.xpath("//button"));
	}
	
	public void LoginToApplication () {
		getUname().sendKeys("kiran@gmail.com");
		getPassword().sendKeys("123456");
		getButtonClicked().click();
	}

}
