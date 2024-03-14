package com.allianz.basics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo5FBSignUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.facebook.com");
		
		//Click on create new account
		
		driver.findElement(By.partialLinkText("Create new account")).click();
		
		//enter firstname as john
		
		driver.findElement(By.name("firstname")).sendKeys("John");
		
		//enter lastname as wick
		
		driver.findElement(By.name("lastname")).sendKeys("Wick");
		driver.findElement(By.name("reg_email__")).sendKeys("john.wick.test.123.456@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("john.wick.test.123.456@gmail.com");
		
		//enter password as test123
		driver.findElement(By.name("reg_passwd__")).sendKeys("test123");
		
		//dropdown 14 apr 1970
		Select selectYear = new Select(driver.findElement(By.id("year")));
		selectYear.selectByVisibleText("1970");		
		
		Select selectMonth = new Select(driver.findElement(By.id("month")));
		selectMonth.selectByValue("4");
		
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByVisibleText("14");
		
		//click on custom radio button
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		//sign up
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}

}
