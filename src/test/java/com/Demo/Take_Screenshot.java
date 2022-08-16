package com.Demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Take_Screenshot {
	@Test
	public void screenshot() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver1.manage().window().maximize();
		driver1.findElement(By.name("email")).sendKeys("sonukumar1239@gmail.com");
		TakesScreenshot ts = (TakesScreenshot) driver1;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/"+"facebook"+".png");
		FileHandler.copy(srcFile,destFile);
	}
}