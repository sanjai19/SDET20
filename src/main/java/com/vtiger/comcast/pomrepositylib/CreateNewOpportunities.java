package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunities {

	public CreateNewOpportunities(WebDriver driver) 
	{		
		PageFactory.initElements(driver,this);
	}
		


	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateImg;

	public WebElement getCreateImg() {
		return CreateImg;
	}
	
}
