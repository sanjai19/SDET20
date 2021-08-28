package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateFilterwithSave {
	
	
	 WebDriver driver;

		public CreateFilterwithSave(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath = "//a[text()='Create Filter']")
	private WebElement CrtFilter;
	
	@FindBy(name = "viewName")
	private WebElement viewNameTF;

	@FindBy(name = "button2")
	private WebElement SaveBtn;
	
	public WebElement getCrtFilter() {
		return CrtFilter;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateFilter() {
		return CrtFilter;
	}

	public WebElement getViewNameTF() {
		return viewNameTF;
	}

}
