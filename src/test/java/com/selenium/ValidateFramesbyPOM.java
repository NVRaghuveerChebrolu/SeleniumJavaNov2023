package com.selenium;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.utility.Library;



public class ValidateFramesbyPOM extends Library {

	@Test(priority=1)
	public void ValidateSingleFrame() {
		System.out.println("inside ValidateSingleFrame");
		driver.get(objProperties.getProperty("FramesURL"));
		driver.switchTo().frame("singleframe");
		driver.findElement(FramesPOM.TextBox).sendKeys(objProperties.getProperty("SingleFrameTextBox"));
		driver.switchTo().defaultContent();//to come out of the frame
		FramesPOM obj = new FramesPOM();
		driver.findElement(obj.IframeWithInIframeButton).click();
	}
	
	@Test(priority=2)
	public void ValidateMultipleFrames() {
		System.out.println("inside ValidateMultipleFrames");
		WebElement OuterFrame = driver.findElement(FramesPOM.OuterFrame);
		driver.switchTo().frame(OuterFrame);
		WebElement InnerFrame = driver.findElement(FramesPOM.InnerFrame);
		driver.switchTo().frame(InnerFrame);
		driver.findElement(FramesPOM.TextBox).sendKeys(objProperties.getProperty("IframeWithInIframeTextBox"));
		driver.switchTo().defaultContent();//to come out of the frames
		
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
