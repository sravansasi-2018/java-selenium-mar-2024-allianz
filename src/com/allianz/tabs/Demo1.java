package com.allianz.tabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;

public class Demo1 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.get("https://db4free.net");
        
        //click on phpMyAdmin »
        driver.findElement(By.partialLinkText("phpMyAdmin")).click();
        
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
       // driver.switchTo().window(windows.get(1));
        
        
        
		/*
		 * driver.close(); driver.switchTo().window(windows.get(0));
		 * System.out.println(driver.getTitle());
		 */
        
        for(String win : windows)
        {
        	System.out.println(win);
        	driver.switchTo().window(win);
        	System.out.println(driver.getTitle());
        	if(driver.getTitle().equals("phpMyAdmin"))
			{
				break;
			}
			System.out.println("----------------------------------");
		}

		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.id("input_username")).sendKeys("admin");
        driver.findElement(By.id("input_password")).sendKeys("admin");
        driver.findElement(By.id("input_go")).click();
        	
        }
        
        
	}


