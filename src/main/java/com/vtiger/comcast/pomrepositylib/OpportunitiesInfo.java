package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesInfo {
	
	
	public OpportunitiesInfo(WebDriver driver) 
	{		
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullmsg;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement succesfullmsgTimeDate;
	
	public WebElement getSuccesfullmsg() {
		return succesfullmsg;
	}

	public WebElement getSuccesfullmsgTimeDate() {
		return succesfullmsgTimeDate;
	}

	public WebElement getsuccesfullmsg()
	{
		return succesfullmsg;
	}


}
