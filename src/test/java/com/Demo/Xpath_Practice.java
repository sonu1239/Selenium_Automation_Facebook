package com.Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Xpath_Practice {
	@Test
	public void login ()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sonukumar1239@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1239@");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		Thread.sleep(2000);
}
	@Test
	public void CreateAccount () throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a [text ()='Create New Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sonu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sharma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("ss316742@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("ss316742@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("sonu@1239");
		Thread.sleep(2000);
		
		WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
		Select select = new Select(day);
		select.selectByVisibleText("2");
		Thread.sleep(2000);
		
	    WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
	    Select select1 = new Select(month);
	    select1.selectByVisibleText("feb");
		Thread.sleep(2000);
		
		WebElement year = driver.findElement(By.xpath("//*[@id='year']"));        
        Select select2 = new Select(year);
        select2.selectByVisibleText("1993");
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		Thread.sleep(2000);
		driver.close();
	}
}