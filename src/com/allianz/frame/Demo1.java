package com.allianz.frame;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo1 {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));
        
        //enter userid as jack123
        driver.findElement(By.name("fldLoginUserId"))
        .sendKeys("jack123");
        //click continue
        driver.findElement(By.linkText("CONTINUE")).click();
        
	}

}
