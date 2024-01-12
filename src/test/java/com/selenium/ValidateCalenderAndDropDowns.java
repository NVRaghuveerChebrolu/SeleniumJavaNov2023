package com.selenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.CalenderPOM;
import com.utility.Library;


public class ValidateCalenderAndDropDowns extends Library {

	@Test(priority=1)
	public void ValidateCalenderTitle() {
		driver.get(objProperties.getProperty("Calender"));
		String Title = driver.getTitle();
		Assert.assertEquals(Title, objProperties.getProperty("TitleOfCalenderPage"));
	}
	
	@Test(priority=2,dependsOnMethods= {"ValidateCalenderTitle"})
	
	public void ValidateCalender() {
		System.out.println("inside ValidateCalender");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		CalenderPOM objCalPOM = new CalenderPOM(driver);
		objCalPOM.Calender.click();
		
		Select objSelect = new Select(objCalPOM.Month);
		//objSelect.selectByValue("5");
		//objSelect.selectByIndex(3);
		objSelect.selectByVisibleText(objProperties.getProperty("MonthOfCalender"));
		
		Select objSelectYear = new Select(objCalPOM.Year);
		objSelectYear.selectByValue(objProperties.getProperty("YearOfCalender"));
		
		List<WebElement> AllDays = objCalPOM.AllDays;
		int Days = AllDays.size();
		for(int Day=0;Day<=Days-1;Day++) {
			String IndividualDay = AllDays.get(Day).getText();
			if(IndividualDay.equalsIgnoreCase(objProperties.getProperty("DayOfCalender"))){
				AllDays.get(Day).click();
				break;
			}
		}
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
		// driver.close();//close the browser that is currently active by web driver
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		System.out.println(objProperties.getProperty("application"));
		LaunchBroswer();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("inside beforeSuite");
		System.out.println(System.getProperty("user.dir"));
		ReadPropetiesFile();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
