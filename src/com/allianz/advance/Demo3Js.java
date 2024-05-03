package com.allianz.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3Js {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://www.citibank.co.in/ssjsps/forgetuseridmidssi.jsp");

		driver.findElement(By.xpath("//a[@class='sbSelector'][text()='select your product type']")).click();
		driver.findElement(By.partialLinkText("Credit Card")).click();

		driver.findElement(By.cssSelector("#citiCard1")).sendKeys("3333");
		driver.findElement(By.cssSelector("input[name='citiCard2']")).sendKeys("3333");
		driver.findElement(By.cssSelector("[name='citiCard3']")).sendKeys("33333");
		driver.findElement(By.cssSelector("#citiCard4")).sendKeys("3333");	

	//	Approach 1 - not working
		//driver.findElement(By.id("bill-date-long")).sendKeys("08/08/2007");
		
		//Approach 2 - working
//		driver.findElement(By.name("DOB")).click();
//		Select objDobYear = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
//		objDobYear.selectByVisibleText("2022");
//		Select objDobMonth = new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
//		objDobMonth.selectByVisibleText("Apr");
//		driver.findElement(By.xpath("//td[@data-handler='selectDay']/child::a[text()='14']")).click();
	
	
	//	document.querySelector('#bill-date-long').click()
    //    document.querySelector('#bill-date-long').value='17/08/2017'
        
         // approach 3 - js
			JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.querySelector('#bill-date-long').value='17/08/2017'");

        // approach 4 - js
        WebElement ele1=driver.findElement(By.xpath("//input[@id='bill-date-long']"));
        js.executeScript("arguments[0].value='17/08/2017'",ele1);

//		driver.quit();

	}

}
