package com.selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.WebtablePOM;
import com.utility.Library;


public class ValidateWebtable extends Library {
	String FirstName="",LastName="",Position="",Office="",StartDate="",Salary="";

	@Test(priority = 1)
	public void ValidateWebTable() {
		driver.get(objProperties.getProperty("WebTableURL"));
		WebtablePOM ObjWebTablePOM = new WebtablePOM(driver);
		ScrollIntoView(ObjWebTablePOM.EmployeeWebTable);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(ObjWebTablePOM.AllLastNames));

		int NumberOfPages = ObjWebTablePOM.AllPages.size();
		System.out.println("NumberOfPages:" + NumberOfPages);
		

		for (int page = 1; page <= NumberOfPages; page++) {
			int NumberOfLastNames = ObjWebTablePOM.AllLastNames.size();
			// System.out.println("NumberOfLastNames:" + NumberOfLastNames);
			for (int row = 0; row <= NumberOfLastNames-1; row++) {
				// System.out.println("NumberOfLastNames" + NumberOfLastNames);
				String IndividualLastName = ObjWebTablePOM.AllLastNames.get(row).getText();
				if(IndividualLastName.equalsIgnoreCase(objProperties.getProperty("WebTableLastName"))) {
					int rownumber = row+1;
					 FirstName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[2]")).getText();
					 LastName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[3]")).getText();
					 Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[4]")).getText();
					 Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[5]")).getText();
					 StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[6]")).getText();
					 Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rownumber+"]/td[7]")).getText();
					System.out.println("FirstName:"+FirstName);
					System.out.println("LastName:"+LastName);
					System.out.println("Position:"+Position);
					System.out.println("Office:"+Office);
					System.out.println("StartDate:"+StartDate);
					System.out.println("Salary:"+Salary);
					break;
				}
				System.out.println("IndividualLastName:" + IndividualLastName);
			}
			if(FirstName.length()>0) {
				break;
			}
			if (page < NumberOfPages) {
				ObjWebTablePOM.AllPages.get(page).click();
				page = page + 1;
				System.out.println("PageNumber:" + page);
				page = page - 1;
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
