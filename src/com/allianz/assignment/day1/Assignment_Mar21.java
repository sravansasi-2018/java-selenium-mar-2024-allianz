package com.allianz.assignment.day1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_Mar21 {

	public static void main(String[] args) {
		

		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	1.  Navigate onto http://demo.openemr.io/b/openemr/
        driver.get("http://demo.openemr.io/b/openemr/");
		//	2.  Update username as admin
        driver.findElement(By.name("authUser")).sendKeys("admin");
		//	3.  Update password as pass
        driver.findElement(By.name("clearPass")).sendKeys("pass");
		//	4.  Select language as English (Indian)
        Select objLangCho = new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
        objLangCho.selectByVisibleText("English (Indian)");        
		//	5.  Click on the login button
		driver.findElement(By.id("login-button")).click();
		//	6.  Click on Patient  Click New Search
		driver.findElement(By.xpath("//div[text()='Patient']")).click();
		driver.findElement(By.xpath("//div[text()='New/Search']")).click();
		//	7.  Add the first name, last name
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		 driver.findElement(By.id("form_fname")).sendKeys("Testfirstname");
		 driver.findElement(By.id("form_lname")).sendKeys("Testlastname");
		//	8.  Update DOB as today's date
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		driver.findElement(By.id("form_DOB")).sendKeys(formattedDate);
		//	driver.findElement(By.id("form_DOB")).sendKeys("2024-01-12");
		//	9.  Update the gender
		Select objGen = new Select(driver.findElement(By.xpath("//select[@id='form_sex']")));
		objGen.selectByVisibleText("Male");
		//	10. . Click on the create new patient button above the form
		driver.findElement(By.id("create")).click();
		//	11. . Click on confirm create new patient button.
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		driver.findElement(By.xpath("//button[text()='Confirm Create New Patient']")).click();
		//	12. . Print the text from alert box (if any error before handling alert add 5 sec wait)
		driver.switchTo().defaultContent();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		 wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String actualAlertText = alert.getText();
	        System.out.println("Alert Message : "+actualAlertText);
		//	13. . Handle alert
	        alert.accept();
		//	14. Close the Happy Birthday popup
	        driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		//	15. Get the added patient name and print in the console.
	        String pname = driver.findElement(By.xpath("//span[@data-bind='text: pname()']")).getText();
	        System.out.println('\n'+"Patient name : "+pname);
	}

}
