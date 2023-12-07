package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPOM {
	WebDriver driver;
	
	public AlertsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="alertButton")
	public WebElement NormalAlert;
	
	@FindBy(id="timerAlertButton")
	public WebElement TimerAlert;
	
	@FindBy(id="confirmButton")
	public WebElement ConfirmALert;
	
	@FindBy(id="confirmResult")
	public WebElement ConfirmResult;
	
	@FindBy(id="promtButton")
	public WebElement PromptAlert;

	@FindBy(id="promptResult")
	public WebElement promptResult;
}
