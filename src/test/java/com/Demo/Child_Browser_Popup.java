package com.Demo;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Child_Browser_Popup {
	public static WebDriver driver;
	@BeforeTest
	public void launch_Browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MY\\Downloads\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();	        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
	}
	@Test
	public void switching_Window() {
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[normalize-space()='Open New Tabbed Windows']")).click();
		driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']")).click();
		driver.getTitle();
		System.out.println(driver.getTitle());
		driver.getWindowHandle();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.close();

		
	}
	@Test
	public void closeParentWindow() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		String parentId=driver.getWindowHandle();
		System.out.println("ParentId" +parentId );
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[normalize-space()='Register now']")).click();
		Set<String> allWindow = driver.getWindowHandles();
		int count=allWindow.size();
		System.out.println("Number of window open by selenium:" +count);
		for(String windowHandle: allWindow) {
			driver.switchTo().window(windowHandle);
			if(windowHandle.equals(parentId)) {
				driver.close();
			}
		}
		
		
		
	}
	@Test
	public void closeAllChildWindow() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		String parentId=driver.getWindowHandle();
//		System.out.println("ParentId" +parentId );
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[normalize-space()='Register now']")).click();
		Set<String> allWindow = driver.getWindowHandles();
		int count=allWindow.size();
//		System.out.println("Number of window open by selenium:" +count);
		for(String windowHandle: allWindow) {
			driver.switchTo().window(windowHandle);
			if(!windowHandle.equals(parentId)) {
				driver.close();
			}
		}
		
	}
	@Test
	public void close_All_Window() {
		driver.get("https://www.naukri.com/");
		//using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = driver.getWindowHandles();
		//using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
//		driver.findElement(By.xpath("//a[normalize-space()='Register now']")).click();
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		//print the window handle id of each browser window
		System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);
		//close all the browsers one by one
		driver.close();
		}

		
	}
	@Test
	public void closeAnySpecificWindow() {
		driver.get("https://www.naukri.com/");
		//Set the expected title of the browser window which you want to close
		String expected_title = "It jobs";
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String actual_title = driver.getTitle();
		//Checks whether the actual title contains the specified expected title
		if (actual_title.contains(expected_title)) {
		driver.close();
		System.out.println("Specified Browser window with title -->"+ actual_title +" --> is closed");
		
		   }
		}  
		
	}
	@Test
	public void handleTabsUsingGetWindowHandles() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String parentwindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("sonu");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("1239@");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> allwhs = driver.getWindowHandles();
		for (String wh : allwhs) {
		driver.switchTo().window(wh);
		String childtitle = driver.getTitle();
		System.out.println("Title of the child tab is :"+ childtitle);
		driver.switchTo().window(parentwindowHandle);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.close();

		}
	}
		  
	
	@Test
	public void visibleLink_invisibleLink() {
		driver.get("https://www.facebook.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//get the total number of link elements
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : "+totalLinks);
		int visibleLinkCount = 0;
		int hiddenLinkCount = 0;
		//using foreach loop, iterate through all the links
		for (WebElement link : allLinks) {
		//if the link is displayed, then print the text of the link
		if (link.isDisplayed()) {
		visibleLinkCount++;
		System.out.println(visibleLinkCount+" --> "+link.getText());
		}else{
		hiddenLinkCount++;
		 }
		}
		System.out.println("Total number of visible links :" + visibleLinkCount);
		System.out.println("Total number of hidden links :" + hiddenLinkCount);
		driver.close();



	}
	@Test
	public void webTable_Example() {
		driver.get("C:\\Users\\MY\\Desktop\\ListBox\\webtabl.html");
		//Count Total number of rows present in the table
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("total number of rows present in the table is :"+ totalRows);
		//count total number of columns
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total number of columns in the table is :" + totalColumns);
		//Count number of cells present in the table
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total number of cells present in the table is :" + totalCells);
		//Print ONLY the numbers
		int countNumberValue = 0;
		int sum=0;
		for (WebElement cell : allCells) {
		String cellValue = cell.getText();
		try{
		int number = Integer.parseInt(cellValue);
		System.out.println("Number is:"+number);
		countNumberValue++;
		sum = sum+number;
		}catch (Exception e) {
		}
		}
		System.out.println("Total count of numeric values is :"+countNumberValue);
		System.out.println("Total sum of all the numeric values is :"+sum);
		//close the browser
		driver.close();




		
	}
	@Test
	public void studentMarks() {
		driver.get("C:\\Users\\MY\\Desktop\\ListBox\\studentM.html");
		//Count Total number of rows present in the table
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("total number of rows present in the table is :"+ totalRows);
		//count total number of columns
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total number of columns in the table is :" + totalColumns);
		//Count number of cells present in the table
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total number of cells present in the table is :" + totalCells);
		//Print ONLY the numbers
		int countNumberValue = 0;
		int sum=0;
		for (WebElement cell : allCells) {
		String cellValue = cell.getText();
		try{
		int number = Integer.parseInt(cellValue);
		System.out.println("Number is:"+number);
		countNumberValue++;
		sum = sum+number;
		}catch (Exception e) {
		}
		}
		System.out.println("Total count of numeric values is :"+countNumberValue);
		System.out.println("Total sum of all the numeric values is :"+sum);
		//close the browser
		driver.close();

	}
	@Test
	public void autosuggestionExGoogleSearch() {
		driver.get("http://www.google.com");
		//Enter Selenium in google search text box
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
	
		List<WebElement> allOptions = 
		driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
		int count = allOptions.size();
		System.out.println("Number of values present in the dropdown is :" + count);
		String expectedValue="selenium interview questions";
		//Print all the auto suggestion values

	
		for (WebElement option : allOptions) {
		String text = option.getText();
		System.out.println(" "+text);
		//Click on Java Interview Questions
		if (text.equalsIgnoreCase(expectedValue)) {
		option.click();
		
		break;
		}
		
		
	  }
	}
}
