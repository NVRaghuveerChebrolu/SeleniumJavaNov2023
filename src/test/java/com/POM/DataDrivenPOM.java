package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenPOM {
	WebDriver driver;
	
	public DataDrivenPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	public WebElement LastName;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	public WebElement Adress;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@type='tel']")
	public WebElement Phone;
	
	@FindBy(xpath="//input[@value='Male']")
	public WebElement Male;
	
	@FindBy(xpath="//input[@value='FeMale']")
	public WebElement Female;
	
	@FindBy(id="checkbox1")
	public WebElement Cricket;
	
	@FindBy(id="checkbox2")
	public WebElement Movies;
	
	@FindBy(id="checkbox3")
	public WebElement Hockey;
	
	@FindBy(id="msdd")
	public WebElement Langugaes;
	
	@FindBy(xpath="//div[@id='msdd']/following-sibling::div/ul/li/a")
	public List<WebElement> AllLanguages;
	
	@FindBy(id="Skills")
	public WebElement Skills;
	
	@FindBy(xpath="//Select[@id='Skills']/option")
	public List<WebElement> Allskills;
	
	@FindBy(id="countries")
	public WebElement Country;
	
	@FindBy(xpath="//label[contains(text(),'Skills')]")
	public WebElement SkillsField;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-close']")
	public WebElement closeSelectedLanguage;
	
	@FindBy(xpath="//span[@role='combobox']")
	public WebElement SelectCountry;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement TextBoxOfCountry;
	
	
	@FindBy(xpath="//select[@placeholder='Month']")
	public WebElement DOB_Month;
	
	@FindBy(xpath="//select[@placeholder='Month']/option")
	public List<WebElement> AllMonths;
	
	@FindBy(xpath="//select[@placeholder='Day']")
	public WebElement DOB_DAY;
	
	@FindBy(xpath="//select[@placeholder='Day']/option")
	public List<WebElement> AllDays;
	
	@FindBy(id="yearbox")
	public WebElement DOB_YEAR;
	
	@FindBy(xpath="//select[@id='yearbox']/option")
	public List<WebElement> AllYears;
	
	@FindBy(id="firstpassword")
	public WebElement Password;
	
	@FindBy(id="secondpassword")
	public WebElement Conformpassword;
	
	
	
	
	
	
	
	

}
