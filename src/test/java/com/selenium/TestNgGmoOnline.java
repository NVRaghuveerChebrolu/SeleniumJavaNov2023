package com.selenium;

import org.testng.annotations.Test;

import com.utility.Library;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestNgGmoOnline extends Library {
	@Test(priority = 0)
	public void LaunchGMO_OnlineApplication() {
		System.out.println("inside LaunchGMO_Application");
		driver.get(objProperties.getProperty("GmoOnlineURL"));
		String title = driver.getTitle();
		System.out.println("titleOfGmoOnlineApp:" + title);
		Assert.assertEquals(title,objProperties.getProperty("TitleOfGmoOnlineApp"));
		System.out.println("after hard assertion");
	}
	
	@Test(priority=1,dependsOnMethods= {"LaunchGMO_OnlineApplication"})
	public void EnterGmoOnline() {
		System.out.println("inside EnterGmoOnline");
		driver.findElement(By.name("bSubmit")).click();
		String title = driver.getTitle();
		System.out.println("titleOfOnlineCatalog:" + title);
		Assert.assertEquals(title,objProperties.getProperty("TitleOfOnLineCatalog"));
	}
	
	@Test(priority=2,dependsOnMethods= {"EnterGmoOnline","LaunchGMO_OnlineApplication"})
	public void PlaceAnOrder() {
		System.out.println("inside PlaceAnOrder");
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("4");
		driver.findElement(By.name("bSubmit")).click();
		String title = driver.getTitle();
		System.out.println("titleOfPlaceOrderPage:" + title);
		Assert.assertEquals(title,objProperties.getProperty("TitleOfPlaceOrder"));
	}
	
	@Test(priority=3)
	public void CalculatePriceInforamtionOnPlaceAnOrderPage() {
		System.out.println("inside CalculatePriceInforamtionOnPlaceAnOrderPage");
		String UnitPriceOfSunGlasses = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/center/table/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPriceOfSunGlasses using Absolute Xpath:"+UnitPriceOfSunGlasses);
		
		String UnitPriceOfSunGlasses1 = driver.findElement(By.xpath("//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPriceOfSunGlasses using Relative Xpath:"+UnitPriceOfSunGlasses1);
		float UnitPrice = Float.parseFloat(UnitPriceOfSunGlasses1.substring(2).trim());
		float CalculatedTotlaPriceInFloatFormat = UnitPrice*4;
		System.out.println("CalculatedTotlaPriceInFloatFormat:"+CalculatedTotlaPriceInFloatFormat);
		
		String TotalPriceFromApplication = driver.findElement(By.xpath("//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[5]")).getText();
		System.out.println("TotalPriceFromApplication:"+TotalPriceFromApplication);
		float TotalPriceFromApplicationInFloatFormat = Float.parseFloat(TotalPriceFromApplication.substring(2).trim());
		System.out.println("TotalPriceFromApplicationInFloatFormat:"+TotalPriceFromApplicationInFloatFormat);

		Assert.assertEquals(CalculatedTotlaPriceInFloatFormat, TotalPriceFromApplicationInFloatFormat);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBroswer();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("inside beforeSuite");
		ReadPropetiesFile();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
