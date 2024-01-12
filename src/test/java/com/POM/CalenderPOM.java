package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPOM {
	WebDriver driver;
	
	public CalenderPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dateOfBirthInput")
	public WebElement Calender;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement Month;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	public WebElement Year;
	
	@FindBy(xpath="//div[@role='listbox']/div/div")
	public List<WebElement> AllDays;

}
