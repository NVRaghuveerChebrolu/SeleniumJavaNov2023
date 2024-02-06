package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Library {
	public Properties objProperties;
	public WebDriver driver;
	public static ExtentHtmlReporter ExtHtmlReptr;
	public static ExtentReports ExtReports;
	public static ExtentTest ExtTest;
	public HashMap<String, String> hmap = new HashMap<String, String>();

	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */
	
	public void StartExtentReport() {
		File ObjFile = new File(System.getProperty("user.dir") + "//test-output//ExtentReportsV4.html");
		ExtHtmlReptr = new ExtentHtmlReporter(ObjFile);
		ExtHtmlReptr.config().setDocumentTitle("Automation Report");
		ExtHtmlReptr.config().setReportName("Automation Results In Extent Report");
		ExtHtmlReptr.config().setTheme(Theme.STANDARD);
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(ExtHtmlReptr);
		ExtReports.setSystemInfo("TesterName", "Raghuveer");
		ExtReports.setSystemInfo("Broswer", objProperties.getProperty("browser"));
		ExtReports.setSystemInfo("Environment", objProperties.getProperty("Environment"));

	}
	
	public void UpdatingResultInExtentReport(ITestResult result) throws IOException {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case Passed is " + result.getName());
			ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));		
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test Case Failed is " + result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
			try {
				ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		}
	}
	
	
	
	public void ReadPropetiesFile() throws IOException {

		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//Configuration.properties");
		try {
			FileInputStream ObjFileInput = new FileInputStream(objFile);
			objProperties = new Properties();
			objProperties.load(ObjFileInput);
			System.out.println("browser:" + objProperties.getProperty("browser"));
			System.out.println("GmoOnlineURL" + objProperties.getProperty("GmoOnlineURL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LaunchBroswer() {
		String browser = objProperties.getProperty("browser");
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please provide browser name as chrome or firefox or edge or ie");
		}
		driver.manage().window().maximize();
		// implicit wait : Global waiting mechanism which is applicable for all
		// WebElements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	public void TakeScreenShot() throws IOException {
		File Source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File Destination = new File(System.getProperty("user.dir")+"//Screenshots//"+dateName+".PNG");
		FileUtils.copyFile(Source, Destination);
	}
	
	public String TakeScreenShot(String TestCaseName) throws IOException {
		// TODO Auto-generated method stub
		File ObjFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String DestFile = System.getProperty("user.dir") + "//ScreenShots//"+TestCaseName+dateName+".jpg";
		FileUtils.copyFile(ObjFile, new File(DestFile));
		return DestFile;

	}
	
	public void ScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public HashMap<String, String> ReadExcelFile(int Row, XSSFSheet objSheet) {
		DataFormatter objDF = new DataFormatter();
		hmap.put("RunMode",objSheet.getRow(Row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName",objSheet.getRow(Row).getCell(1).getStringCellValue());
		hmap.put("FirstName",objSheet.getRow(Row).getCell(2).getStringCellValue());
		hmap.put("LastName",objSheet.getRow(Row).getCell(3).getStringCellValue());
		hmap.put("Address",objSheet.getRow(Row).getCell(4).getStringCellValue());
		hmap.put("Email",objSheet.getRow(Row).getCell(5).getStringCellValue());
		
		hmap.put("PhoneNumber",objDF.formatCellValue(objSheet.getRow(Row).getCell(6)));
		
		hmap.put("Gender",objSheet.getRow(Row).getCell(7).getStringCellValue());
		hmap.put("Hobbies",objSheet.getRow(Row).getCell(8).getStringCellValue());
		hmap.put("Languages",objSheet.getRow(Row).getCell(9).getStringCellValue());
		hmap.put("Skills",objSheet.getRow(Row).getCell(10).getStringCellValue());
		hmap.put("Country",objSheet.getRow(Row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry",objSheet.getRow(Row).getCell(12).getStringCellValue());
		
		hmap.put("DOB_YY",objDF.formatCellValue(objSheet.getRow(Row).getCell(13)));
		
		hmap.put("DOB_MM",objSheet.getRow(Row).getCell(14).getStringCellValue());
		
		hmap.put("DOB_DD",objDF.formatCellValue(objSheet.getRow(Row).getCell(15)));
		
		hmap.put("Password",objSheet.getRow(Row).getCell(16).getStringCellValue());
		hmap.put("conformPassword",objSheet.getRow(Row).getCell(17).getStringCellValue());
		return hmap;


	}
	
	public void SelectValueFromDropDown(List<WebElement> AllDropDownItems, String ExpectedDropDownValue) {
		int Count= AllDropDownItems.size();
		for(int i=0;i<=Count-1;i++) {
			WebElement DropDownItem = AllDropDownItems.get(i);
			String IndividualDropDownValue = DropDownItem.getText();
			if(IndividualDropDownValue.equalsIgnoreCase(ExpectedDropDownValue)){
				AllDropDownItems.get(i).click();
				break;
			}
		}
	}

}
