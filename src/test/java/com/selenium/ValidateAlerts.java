package com.selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.Library;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlerts extends Library {

  @Test (priority=1)
  public void ValidateNormalAlert() throws InterruptedException {
	  System.out.println("inside ValidateNormalAlert");
	  driver.get(objProperties.getProperty("AlertsUrl"));
	  driver.findElement(By.id("alertButton")).click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String TextOfAlert = objAlert.getText();
	  Assert.assertEquals(TextOfAlert, "You clicked a button");
	  objAlert.accept();
  }

  @Test(priority=2)
  public void ValidateTimerAlert() {
	  System.out.println("inside ValidateTimerAlert");
	  driver.findElement(By.id("timerAlertButton")).click();
	  //Explicit Wait : Applicable for only one specific web element.
	  //It will wait until expected condition is satisfied for a specified time duration.
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert = driver.switchTo().alert();
	  String TextOfTimerAlert = objAlert.getText();
	  Assert.assertEquals(TextOfTimerAlert, "This alert appeared after 5 seconds");
	  objAlert.accept();

  }

  @Test(priority=3)
  public void ValidateConfirmBoxAlert() {
	  System.out.println("inside ValidateConfirmBoxAlert");
	  driver.findElement(By.id("confirmButton")).click();
	  Alert objAlert = driver.switchTo().alert();
	  String TextOfConfirmAlert = objAlert.getText();
	  SoftAssert SAssert = new SoftAssert();
	  SAssert.assertEquals(TextOfConfirmAlert, "Do you confirm actio");
	 // Assert.assertEquals(TextOfConfirmAlert, "Do you confirm action?");
	  objAlert.dismiss();
	  String ResultOfConfirmAlert = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
	  Assert.assertEquals(ResultOfConfirmAlert, "You selected Cancel");
	  SAssert.assertAll();//should be the last line in the test case
  }

  @Test (priority=4)
  public void ValidatePromptBoxAlert() {
	  System.out.println("inside ValidatePromptBoxAlert");
	  driver.findElement(By.id("promtButton")).click();
	  Alert objAlert = driver.switchTo().alert();
	  objAlert.sendKeys("Hi How are you");
	  objAlert.accept();
	  String ResultOfPromptAlert = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
	  Assert.assertEquals(ResultOfPromptAlert, "You entered Hi How are you");

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