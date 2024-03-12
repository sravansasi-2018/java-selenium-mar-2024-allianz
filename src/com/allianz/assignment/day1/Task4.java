package com.allianz.assignment.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));	
		
			//1. Navigate onto https://nasscom.in/
		driver.get("https://nasscom.in/");

			//2. Click on Login and then click on register
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.xpath("//li[text()='register']")).click();
		
			//3. Enter First name as admin
		driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input"))
		.sendKeys("admin");
		
			//4. Enter Last name as pass
		driver.findElement(By.xpath("//label[text()='Last name']/following-sibling::input"))
		.sendKeys("pass");
		
			//5. Enter email address as admin@gmail.com
		driver.findElement(By.xpath("//label[text()='Email address']/following-sibling::input"))
		.sendKeys("admin@gmail.com");
		
			//6. Enter company name as Google
		driver.findElement(By.xpath("//label[text()='Company Name']/following-sibling::input"))
		.sendKeys("Google");
		
			//7. Select IT Consulting from dropdown		
		Select objCompany = new Select(driver.findElement(By.xpath("//label[text()='Business focus']/following-sibling::select")));
		objCompany.selectByVisibleText("IT Consulting");
		
			//8. No need to automate CAPTCHA

			//9. Click on Register
		driver.findElement(By.xpath("//input[@value='Register']")).click();

		String error = driver.findElement(By.xpath("//span[@id='email_error']")).getText();
		System.out.println("Error Message : "+ error);
		
		driver.quit();
	}

}
