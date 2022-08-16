package com.Demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUploadAutoIT {
	
@Test
	
	
	public void FileUplod() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		  Thread.sleep(4000);
		  driver.manage().window().maximize();
		  
	    driver.get("https://the-internet.herokuapp.com/upload");
	      Thread.sleep(2000);
	      //find choose file web element
	      //driver.findElement(By.id("file-upload")).click();
	      
	     WebElement button= driver.findElement(By.id("file-upload"));
	      Actions act = new Actions(driver);
	      act.moveToElement(button).click().perform();
	      Thread.sleep(4000);
	      Runtime.getRuntime().exec("C:\\Users\\MY\\Downloads\\FileUplod1.exe");
	      Thread.sleep(4000);
	      driver.findElement(By.id("file-submit")).click();
}
}
