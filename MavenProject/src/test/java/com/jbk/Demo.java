package com.jbk;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Demo {
	
	@Test(dataProvider = "dp")

	public void f(String Name, String Mobile, String Email, String PW) throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/register.html");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("name")).sendKeys(Name);
		driver.findElement(By.id("mobile")).sendKeys(Mobile);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(PW);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();

		if (Name == "") {

			String Nameerror = driver.findElement(By.id("name_error")).getText();
			Assert.assertEquals(Nameerror, "Please enter Name.");

		}

		else if (Mobile == "") {
			String MobileError = driver.findElement(By.id("mobile_error")).getText();
			Assert.assertEquals(MobileError, "Please enter Mobile.");
		}

		else if (Email == "") {
			String EmailError = driver.findElement(By.id("email_error")).getText();
			Assert.assertEquals(EmailError, "Please enter Email.");
		}

		else if (PW == "") {
			String PWerror = driver.findElement(By.id("password_error")).getText();
			Assert.assertEquals(PWerror, "Please enter Password.");
		}

		else {

			Alert alert = driver.switchTo().alert();

			Thread.sleep(3000);

			alert.accept();
		}

		driver.quit();
	}

	@DataProvider

	public Object[][] dp() throws Exception {

		FileInputStream fis = new FileInputStream("E:\\Registration.xls");

		Workbook workbook = Workbook.getWorkbook(fis);

		Sheet sheet = workbook.getSheet(0);

		int rows = sheet.getRows();
		int column = sheet.getColumns();

		String exdata[][] = new String[rows][column];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < column; j++) {

				Cell cell = sheet.getCell(j, i);

				String Value = cell.getContents();

				exdata[i][j] = Value;

			}

		}
		return exdata;

	}
	

}
