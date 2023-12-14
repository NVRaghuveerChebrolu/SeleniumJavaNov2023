package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseOperationsPOM {
	public WebDriver driver;
	
	public MouseOperationsPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Delete']")
	public WebElement DeleteOption;
	
	@FindBy(xpath="//span[text()='right click me']")
	public WebElement RightClickMeButton;
	
	@FindBy(xpath="//button[@ondblclick='myFunction()']")
	public WebElement DoubleClickButton;
	
	@FindBy(xpath="//iframe[@class='demo-frame']")
	public WebElement iframe;
	
	@FindBy(id="draggable")
	public WebElement source;
	
	@FindBy(id="droppable")
	public WebElement target;
	
	
}
