package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebtablePOM {
	public WebDriver driver;
	
	public WebtablePOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='example_paginate']/span/a")
	public List<WebElement> AllPages;
	
	@FindBy(xpath="//table[@id='example']")
	public WebElement EmployeeWebTable;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[3]")
	public List<WebElement> AllLastNames;
}
