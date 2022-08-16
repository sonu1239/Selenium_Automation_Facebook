package com.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frame_Demo {
	@Test
	public void frame() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\MY\\Desktop\\frame");
		Thread.sleep(2000);

		driver.switchTo().frame(0);

		driver.findElement(By.id("t1")).sendKeys("a");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("a");
//		//using id attribute of the frame -string
//		driver.switchTo().frame("f1");
//		driver.findElement(By.id("t1")).sendKeys("b");
//		driver.switchTo().defaultContent();
//		driver.findElement(By.id("t2")).sendKeys("b");
//		//using name attribute of the frame -string
//		driver.switchTo().frame("n1");
//		driver.findElement(By.id("t1")).sendKeys("c");
//		driver.switchTo().defaultContent();
//		driver.findElement(By.id("t2")).sendKeys("c");
//		//using address of the frame -webelement
//		WebElement f = driver.findElement(By.className("c1"));
//		driver.switchTo().frame(f);
//		driver.findElement(By.id("t1")).sendKeys("d");
//		driver.switchTo().defaultContent();
//		driver.findElement(By.id("t2")).sendKeys("d");
		driver.close();
	}
}