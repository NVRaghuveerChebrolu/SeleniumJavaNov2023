package com.selenium;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

import com.POM.FileUploadPOM;
import com.utility.Library;



public class ValidateFileDownload extends Library {

	@Test(priority = 1)
	public void ValidtaeFileDownloadPageLoadedSuccessfullt() throws UnsupportedFlavorException, IOException, AWTException, InterruptedException {
		driver.get(objProperties.getProperty("FileDownload"));
		String Title = driver.getTitle();
		Assert.assertEquals(Title, objProperties.getProperty("titleOfFileDownloadPage"));
	
	}
	
	@Test(priority=2)
	public void ValidateFileDownload() throws InterruptedException {
		System.out.println("inside ValidateFileDownload");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		FileUploadPOM objFileDownload = new FileUploadPOM(driver);
		objFileDownload.BrowseButton.click();
		Thread.sleep(6000);
		File objFile = new File(System.getProperty("user.dir"));
		File[] AllFiles =objFile.listFiles();
		
		for(File IndividualFile:AllFiles) {
			Boolean FileFound = false ;
			String NameOfFile = IndividualFile.getName();
			if(NameOfFile.contains("500kB")) {
				FileFound=true;
				Assert.assertTrue(true, "FileDownloadedIsNotFound");
				IndividualFile.delete();
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
