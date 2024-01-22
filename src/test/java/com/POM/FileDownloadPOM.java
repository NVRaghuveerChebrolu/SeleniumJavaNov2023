package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPOM {
	public WebDriver driver;
	
	public FileDownloadPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td[text()='500kB']/following-sibling::td/a")
	public WebElement file500KB;

}
