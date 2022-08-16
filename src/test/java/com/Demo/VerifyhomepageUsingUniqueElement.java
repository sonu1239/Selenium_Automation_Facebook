package com.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyhomepageUsingUniqueElement {
	@Test
	public void uniqueElement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("username")).sendKeys("admin");

		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Thread.sleep(3000);
		WebElement logoutBtn = driver.findElement(By.xpath("//a[.='Logout']"));
		if (logoutBtn.isDisplayed()) {
			System.out.println("Home page is displayed");
		} else{
			System.out.println("Home page is NOT displayed");
		}
	}
}
