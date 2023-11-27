package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchAmazon {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		System.out.println("Hello! How are you?");
//		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		String title = driver.getTitle();
		System.out.println("title:"+title);
		driver.close();
	}
	
	
}
