package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.POM.WindowsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingWindows extends Library {

	@Test(priority = -2)
	public void ValidatingWindowsPageTitle() {
		driver.get(objProperties.getProperty("nxtgenaiacademyURL"));
		String TitleOfAlertsPage = driver.getTitle();
		Assert.assertEquals(TitleOfAlertsPage, objProperties.getProperty("nxtgenaiacademyTitle"));
	}

	@Test(priority = 1)
	public void ValidateNewBrowserWindow() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Thread.sleep(8000);
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = driver.findElement(WindowsPOM.NewBrowserWindwButton);
		//wait.until(ExpectedConditions.elementToBeClickable(element)); 
		//element.click();
		//Actions actions = new Actions(driver); 
		//actions.moveToElement(element).click().build().perform();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		String ParentWindowHandle = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for (String Window : AllWindows) {
			driver.switchTo().window(Window);
			String title = driver.getTitle();
			if (title.equals(objProperties.getProperty("newBrowserWindowTitle"))) {
				Thread.sleep(6000);
				driver.findElement(WindowsPOM.MenuIcon).click();
				Thread.sleep(6000);
				driver.findElement(WindowsPOM.DemoSites).click();
				Thread.sleep(6000);
				//driver.close();//close the browser where the driver is currently active 
				driver.quit();//close all the existing browsers
				break;
			}
		}
		//driver.switchTo().window(ParentWindowHandle);
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("insde before Test");
		LaunchBroswer();
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("inside before suite");
		ReadPropetiesFile();
	}

	@AfterSuite
	public void afterSuite() {

	}

}
