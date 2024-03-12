package com.allianz.assignment.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.get("https://www.citibank.co.in/ssjsps/forgetuserid.jsp");
		
		//select credit card type	
		driver.findElement(By.xpath("//a[@class='sbSelector'][text()='select your product type']")).click();
		driver.findElement(By.partialLinkText("Credit Card")).click();

		//entercard details	
		driver.findElement(By.id("citiCard1")).sendKeys("4545");
		driver.findElement(By.id("citiCard2")).sendKeys("5656");
		driver.findElement(By.id("citiCard3")).sendKeys("8887");
		driver.findElement(By.id("citiCard4")).sendKeys("9998");
		driver.findElement(By.id("cvvnumber")).sendKeys("123");
		
		//enter DOB
		driver.findElement(By.name("DOB")).click();
		Select objDobYear = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
		objDobYear.selectByVisibleText("2022");
		Select objDobMonth = new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
		objDobMonth.selectByVisibleText("Apr");
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/child::a[text()='14']")).click();
		
		//click proceed
		driver.findElement(By.xpath("//input[@value='PROCEED']")).click();
		
		//get error message
		String error = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']/child::li")).getText();
		System.out.println("Error Message : "+ error);
		
		driver.quit();
		

	}

	

}
