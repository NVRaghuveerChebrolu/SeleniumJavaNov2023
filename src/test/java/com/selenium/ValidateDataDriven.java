package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.DataDrivenPOM;
import com.utility.Library;

	

public class ValidateDataDriven extends Library {
	HashMap<String,String> hmap = new HashMap<String,String>();

	@Test(priority=1)
	public void ValidateDataDriven() throws IOException, AWTException {
		System.out.println("inside data driven");
		driver.get(objProperties.getProperty("AutomationRegister"));
		try {
			File objFile = new File(System.getProperty("user.dir") + "/src/test/resources/AutomationDemoSite.xlsx");
			FileInputStream objFileInput = new FileInputStream(objFile);
			
			// XSSFWorkbook and XSSFSheet -> use these if excel file extension is .xlsx
			XSSFWorkbook objWorkBook = new XSSFWorkbook(objFileInput);
			XSSFSheet objSheet = objWorkBook.getSheet("TestData");

			// HSSFWorkbook and HSSFSheet -> use these if excel file extension is .xls
			//HSSFWorkbook objWorkBook1 = new HSSFWorkbook(objFileInput);
			//HSSFSheet objSheet1 = objWorkBook1.getSheet("TestData");
			
			int NumberOfRows = objSheet.getLastRowNum();
			System.out.println("NumberOfRows:"+NumberOfRows);
			for(int Row =1 ; Row<=NumberOfRows;Row++) {
				hmap=ReadExcelFile(Row,objSheet);
				DataDrivenPOM objDDPOM = new DataDrivenPOM(driver);
				
				objDDPOM.FirstName.clear();
				objDDPOM.FirstName.sendKeys(hmap.get("FirstName"));
				
				objDDPOM.LastName.clear();
				objDDPOM.LastName.sendKeys(hmap.get("LastName"));
				
				objDDPOM.Adress.clear();
				objDDPOM.Adress.sendKeys(hmap.get("Address"));
				
				objDDPOM.Email.clear();
				objDDPOM.Email.sendKeys(hmap.get("Email"));
				
				objDDPOM.Phone.clear();
				objDDPOM.Phone.sendKeys(hmap.get("PhoneNumber"));
				
				if(hmap.get("Gender").equals("Male")) {
					objDDPOM.Male.click();
				}else {
					objDDPOM.Female.click();
				}
				
				if(hmap.get("Hobbies").equals("Cricket")) {
					objDDPOM.Cricket.click();
				}else if (hmap.get("Hobbies").equals("Hockey")){
					objDDPOM.Hockey.click();
				}else {
					objDDPOM.Movies.click();
				}
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
				
				if(Row>1) {
					objDDPOM.closeSelectedLanguage.click();
				}
				
				objDDPOM.Langugaes.click();
				SelectValueFromDropDown(objDDPOM.AllLanguages,hmap.get("Languages"));
				
				objDDPOM.SkillsField.click();
				
				objDDPOM.Skills.click();
				SelectValueFromDropDown(objDDPOM.Allskills,hmap.get("Skills"));
				
				objDDPOM.SelectCountry.click();
				objDDPOM.TextBoxOfCountry.sendKeys(hmap.get("SelectCountry"));
				
				Robot objRobot = new Robot();
				objRobot.keyPress(KeyEvent.VK_ENTER);
				objRobot.keyRelease(KeyEvent.VK_ENTER);
				
				objDDPOM.DOB_YEAR.click();
				SelectValueFromDropDown(objDDPOM.AllYears,hmap.get("DOB_YY"));
				
				objDDPOM.DOB_Month.click();
				SelectValueFromDropDown(objDDPOM.AllMonths,hmap.get("DOB_MM"));
				
				objDDPOM.DOB_DAY.click();
				SelectValueFromDropDown(objDDPOM.AllDays,hmap.get("DOB_DD"));
				
				objDDPOM.Password.clear();
				objDDPOM.Password.sendKeys(hmap.get("Password"));
				
				objDDPOM.Conformpassword.clear();
				objDDPOM.Conformpassword.sendKeys(hmap.get("conformPassword"));
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
