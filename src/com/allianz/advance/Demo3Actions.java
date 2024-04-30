package com.allianz.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo3Actions {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		
		Actions action=new Actions(driver);

		action.keyDown(Keys.SHIFT).sendKeys("hello world").keyUp(Keys.SHIFT).pause(1000)
			.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(1000)
			.sendKeys(Keys.ENTER).perform();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
        
	}

}
