package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

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

import com.POM.FileDownloadPOM;
import com.utility.Library;



public class ValidateFileUpload extends Library {

	@Test(priority = 1)
	public void ValidtaeFileupload() throws UnsupportedFlavorException, IOException, AWTException, InterruptedException {
		driver.get(objProperties.getProperty("FileUpload"));
		String title = driver.getTitle();
		Assert.assertEquals(title, objProperties.getProperty("TiTleOfFileupload"));
		FileDownloadPOM ObjFU = new FileDownloadPOM(driver);
		Actions objActions = new Actions(driver);
		//driver.navigate().refresh();
		objActions.click(ObjFU.file500KB).build().perform();
		
		File ObjFile = new File(System.getProperty("user.dir")+"/src/test/resources/Materials/SampleFileToUpload.jpg");
		StringSelection objStringSelection = new StringSelection(ObjFile.toString());
		Clipboard objclipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objclipboard.setContents(objStringSelection,null);
		Transferable objTransferable = objclipboard.getContents(null);
		if(objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
		}
		Robot objRobot = new Robot();
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		objRobot.keyRelease(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		
		
		Clipboard objclipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		objclipboard1.setContents(objStringSelection,null);
		Transferable objTransferable1 = objclipboard1.getContents(null);
		if(objTransferable1.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			System.out.println(objTransferable1.getTransferData(DataFlavor.stringFlavor));
		}
		Robot objRobot1 = new Robot();
		objRobot1.keyPress(KeyEvent.VK_ENTER);
		objRobot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		objRobot1.keyPress(KeyEvent.VK_CONTROL);
		objRobot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		objRobot1.keyRelease(KeyEvent.VK_V);
		objRobot1.keyRelease(KeyEvent.VK_CONTROL);
		
		objRobot1.keyPress(KeyEvent.VK_ENTER);
		objRobot1.keyRelease(KeyEvent.VK_ENTER);
		
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
