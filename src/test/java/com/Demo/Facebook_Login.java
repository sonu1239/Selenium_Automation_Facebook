package com.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook_Login {

	@Test
	public void login() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\MY\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		 //WebDriver driver = new ChromeDriver();
		 WebDriver driver = new FirefoxDriver();
		  Thread.sleep(4000);
	    driver.get("https://www.facebook.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.name("email")).sendKeys("sonu");
	    Thread.sleep(2000);
	    driver.findElement(By.id("pass")).sendKeys("1239");
	    Thread.sleep(2000);
	    driver.findElement(By.name("login")).click();
	    Thread.sleep(2000);
	}
	}