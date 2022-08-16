package com.Demo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class FileDownloadInChromeBrowser { 
	
	@Test
	 public void Filedownlod() throws InterruptedException { 
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
	  //Create Hashmap object and assign the profile settings 
	  HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
	  chromePrefs.put("profile.default_content_settings.popups", 0); 
	  chromePrefs.put("download.default_directory", "E:\\fileD"); 
	  //Assign this chromePrefs object with ChromeOptions object  
	  ChromeOptions options = new ChromeOptions(); 
	  options.setExperimentalOption("prefs", chromePrefs); 
	  //Create Capability object and assign the option object 
	  DesiredCapabilities cap = new DesiredCapabilities(); 
	  cap.setCapability(ChromeOptions.CAPABILITY, options); 
	  WebDriver driver = new ChromeDriver(cap);  
	  driver.get("http://www.seleniumhq.org/download/"); 
	  Thread.sleep(3000); 
	  driver.findElement(By.xpath("//div[3]//div[1]//div[2]//p[2]//a[1]")).click(); 
	 } 
	} 
	
