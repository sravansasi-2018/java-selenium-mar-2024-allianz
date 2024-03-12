package com.allianz.assignment.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));	
//1. Navigate onto https://www.medibuddy.in/
		driver.get("https://www.medibuddy.in/");	
//2. Close if any popup and Click on Login
		Thread.sleep(3000);
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//a[@class='wzrkClose']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.partialLinkText("Login")).click();		
//3. Click on I have Corporate Account
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='I have a Corporate Account']")).click();		
//4. Click on Learn More
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Learn More")).click();		
//5. Click on Skip
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("skip")).click();		
//6. Click on Login using Username & Password
		driver.findElement(By.partialLinkText("Login using Username & Password")).click();		
//7. Enter username as john
		driver.findElement(By.id("username")).sendKeys("john");
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();		
//8. Enter password as john123
		driver.findElement(By.id("password")).sendKeys("john123");		
//9. Click on show password
		driver.findElement(By.xpath("//img[@alt='hide-password']")).click();		
//10. Click log in
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();		
//11. Get the error message shown and print it in terminal
		String error = driver.findElement(By.xpath("//div[@ng-if='isPasswordWrong']")).getText();
		System.out.println("Error Message : "+ error);
		
		driver.quit();
	}

}
