package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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


public class testNgAnnotations {
	Properties objProp;
  @Test
  public void testCase1() {
	  System.out.println("inside testCase1");
  }
  
  @Test(priority=-8)
  public void testCase2() {
	  System.out.println("inside testCase2");
  }
  
  @Test(priority=2,invocationCount=3)
  public void testCase3() {
	  System.out.println("inside testCase3");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void TestCase4() {
	  System.out.println("inside testCase4");
  }
  
  @Test(priority=-3)
  public void testCase5() {
	  System.out.println("inside testCase5");
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
	  System.out.println(objProp.getProperty("application"));
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  System.out.println("inside beforeSuite");
	  System.out.println(System.getProperty("user.dir"));
	  try {
	  File objFile = new File(System.getProperty("user.dir")+"/src/test/resources/configuration.properties");
	  FileInputStream objFileInput = new FileInputStream(objFile);
	  objProp = new Properties();
	  objProp.load(objFileInput);
	  String application = objProp.getProperty("application");
	  String browser = objProp.getProperty("browser");
	  System.out.println("application:"+application);
	  System.out.println("browser:"+browser);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //FileOutputStream
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}
