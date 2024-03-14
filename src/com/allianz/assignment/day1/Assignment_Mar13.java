package com.allianz.assignment.day1;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_Mar13 {

	public static void main(String[] args) {
		
//mar 14


	//	1.  Navigate onto https://www.online.citibank.co.in/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.get("https://www.online.citibank.co.in/");
	//	2.  Close if any pop up comes
		driver.findElement(By.xpath("//a[@class='newclose']")).click();
		driver.findElement(By.xpath("//a[@class='newclose2']")).click();
	//	3.  Click on Login
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	//	4.  Click on Forgot User ID?
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//div[contains(@onclick,'ForgotUserID')]")).click();
	//	5.  Choose Credit Card
		driver.findElement(By.xpath("//a[@class='sbSelector'][text()='select your product type']")).click();
		driver.findElement(By.partialLinkText("Credit Card")).click();
	//	6.  Enter credit card number as 4545 5656 8887 9998
		driver.findElement(By.id("citiCard1")).sendKeys("4545");
		driver.findElement(By.id("citiCard2")).sendKeys("5656");
		driver.findElement(By.id("citiCard3")).sendKeys("8887");
		driver.findElement(By.id("citiCard4")).sendKeys("9998");	
	//	7.  Enter cvv number
		driver.findElement(By.id("cvvnumber")).sendKeys("123");
	//	8.  Enter date as “14/04/2022”
		driver.findElement(By.name("DOB")).click();
		Select objDobYear = new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));
		objDobYear.selectByVisibleText("2022");
		Select objDobMonth = new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
		objDobMonth.selectByVisibleText("Apr");
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/child::a[text()='14']")).click();
	//	9.  Click on Proceed
		driver.findElement(By.xpath("//input[@value='PROCEED']")).click();
	//	10.  Get the text and print it “Please accept Terms and Conditions”
		String error = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']/child::li")).getText();
		System.out.println("Error Message : "+ error);
		
		driver.quit();


	}

}
