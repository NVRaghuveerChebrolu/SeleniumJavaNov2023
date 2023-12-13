package com.POM;

import org.openqa.selenium.By;

public class FramesPOM {
	public static final By TextBox = By.xpath("//input[@type='text']");
	public final By IframeWithInIframeButton = By.xpath("//a[contains(text(),'Iframe with in')]");
	public static final By OuterFrame = By.xpath("//iframe[@src='MultipleFrames.html']");
	public static final By InnerFrame = By.xpath("//iframe[@src='SingleFrame.html']");
}
