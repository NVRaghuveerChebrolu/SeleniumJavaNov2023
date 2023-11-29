package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumProgram {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bankofamerica.com/");
		//driver.findElement(By.id("navChecking")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div/div/div[1]/div[1]/div/nav/ul/li[1]/a/span[3]")).click();
		driver.findElement(By.xpath("//a[@aria-controls='navCheckingContent']")).click();
		//driver.findElement(null).sendKeys("iphone 14");
		String title = driver.getTitle();
		System.out.println(title);
		//Thread.sleep(8000);
		//driver.close();
	}

}
