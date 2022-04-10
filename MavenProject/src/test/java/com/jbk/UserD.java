package com.jbk;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class UserD {
	
	@Test(dataProvider = "dp")
	public void f(String Username, String Mobile, String Email, String Courses, String Gender, String State, String PW,
			String FriendMobile) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"file:///E:/Automation%20testing/Class%20video%20link/Offline%20website/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(Mobile);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys(Courses);

		WebElement radio = driver.findElement(By.id("Male"));

		radio.click();

		Select drpstate = new Select(driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));

		drpstate.selectByVisibleText(State);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[3]/div/input"))
				.sendKeys(FriendMobile);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();
	

		driver.quit();

	}

	@DataProvider
	public Object[][] dp() throws Exception {

		FileInputStream fis = new FileInputStream("E:\\Users.xls");

		Workbook workbook = Workbook.getWorkbook(fis);

		Sheet sheet = workbook.getSheet(0);

		int rows = sheet.getRows();
		int column = sheet.getColumns();

		String userdata[][] = new String[rows][column];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {

				Cell cell = sheet.getCell(j, i);

				String value = cell.getContents();

				userdata[i][j] = value;

			}

		}
		return userdata;

	}

}
