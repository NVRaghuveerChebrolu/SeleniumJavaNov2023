package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQueryPage {
	
	public static By RightClickMe = By.xpath("//span[contains(text(),'right click me')]");
	public static By Paste = By.xpath("//span[text()='Paste']");
	public static By Copy = By.xpath("//span[text()='Copy']");
	public static By Frame = By.xpath("//iframe");
	public static By DoubleClickBox = By.xpath("//span[text()='Double click the block']/preceding-sibling::div");
	public static By Draggable = By.id("draggable");
	public static By Droppable = By.id("droppable");

	
	

}
