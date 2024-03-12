package com.allianz.assignment.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");
		
		//enter firstname as john	
		driver.findElement(By.name("UserFirstName")).sendKeys("John");
		//enter lastname as wick	
		driver.findElement(By.name("UserLastName")).sendKeys("Wick");
		//enter email as john@gmail.com	
		driver.findElement(By.name("UserEmail")).sendKeys("john@gmail.com");
		//enter JobTitle	
		Select objJobTitle = new Select(driver.findElement(By.name("UserTitle")));
		objJobTitle.selectByVisibleText("IT Manager");
		//enter CompanyName	
		driver.findElement(By.name("CompanyName")).sendKeys("Test");
		//enter Employees
		Select objEmployees = new Select(driver.findElement(By.name("CompanyEmployees")));
		objEmployees.selectByVisibleText("201 - 500 employees");
		//enter Country
		Select objCountry = new Select(driver.findElement(By.name("CompanyCountry")));
		objCountry.selectByVisibleText("United Kingdom");
		//removing unwanted popups
		driver.findElement(By.xpath("//div[@class='formContainerV2 parbase section']")).click();
		driver.findElement(By.xpath("//button[@id='rejectInvite']")).click();
		//click checkbox
		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div")).click();
		//click start on free trial
		driver.findElement(By.name("start my free trial")).click();
		//get error message
		String error = driver.findElement(By.xpath("//label[contains(text(),'Phone')]/following-sibling::span[@class='error-msg']")).getText();
		System.out.println("Error Message : "+ error);
		
		driver.quit();
		

	}

}
