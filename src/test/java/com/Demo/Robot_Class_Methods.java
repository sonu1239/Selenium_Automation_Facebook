package com.Demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Robot_Class_Methods {
	@Test
	public void mouseAndKeyboardOperation() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("sonukumar1239@gmail.com");
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.mouseMove(300, 400);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F);
		
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(2000);
		
		robot.keyRelease(KeyEvent.VK_W);
		Thread.sleep(2000);
		driver.close();
	}
}