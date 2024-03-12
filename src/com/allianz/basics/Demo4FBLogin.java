package com.allianz.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4FBLogin {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("hello12345@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("jacl123");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.partialLinkText("Log in")).click();
		

	}

}
