package com.selenium;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
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

import com.POM.MouseOperationsPOM;
import com.utility.Library;



public class ValidateMouseOperations extends Library{
	
	@Test(priority=1)
	public void ValidateRightClickOperation() throws InterruptedException {
		driver.get(objProperties.getProperty("mouseOpeartionRightClick"));
		MouseOperationsPOM objMouseOP_POM = new MouseOperationsPOM(driver);
		Actions objActions = new Actions(driver);
		//WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));
		objActions.contextClick(objMouseOP_POM.RightClickMeButton).build().perform();
		Thread.sleep(3000);
		//WebElement deleteElement = driver.findElement(By.xpath("//span[text()='Delete']"));
		//deleteElement.click();
		objActions.click(objMouseOP_POM.DeleteOption).build().perform();
		Alert objAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		String Text = objAlert.getText();
		Assert.assertEquals(Text,objProperties.getProperty("mouseOpeartionRightclick_DeleteAlertText"));
		objAlert.accept();
	}
	
	
	@Test(priority=2)
	public void ValidateDoubleClickOperation() throws InterruptedException {
		driver.navigate().to(objProperties.getProperty("mouseOpeartionDoubleClick"));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		MouseOperationsPOM objMouseOP_POM = new MouseOperationsPOM(driver);
		Actions objAction = new Actions(driver);
		objAction.doubleClick(objMouseOP_POM.DoubleClickButton).build().perform();
		Alert objALert = driver.switchTo().alert();
		//Thread.sleep(3000);
		String InnertText = objALert.getText();
		Assert.assertEquals(InnertText,objProperties.getProperty("DoubleClickAlertInnertText"));
		objALert.accept();
	}
	
	@Test(priority=3)
	public void ValidateDragAndDropOperation() {
		driver.navigate().to(objProperties.getProperty("mouseOperationDragAndDrop"));
		MouseOperationsPOM objMouseOP_POM = new MouseOperationsPOM(driver);
		driver.switchTo().frame(objMouseOP_POM.iframe);
		Actions objActions = new Actions(driver);
		objActions.dragAndDrop(objMouseOP_POM.source, objMouseOP_POM.target).build().perform();
		String InnerTextOfTarget = objMouseOP_POM.target.getText();
		Assert.assertEquals(InnerTextOfTarget, objProperties.getProperty("TextOfTarget"), "Target Inner Text is not validated!");
		driver.switchTo().defaultContent();
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
