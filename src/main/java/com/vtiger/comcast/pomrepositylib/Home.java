package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	 WebDriver driver;

	public Home(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlnk;

	public WebElement getOpportunitieslnk() {
		return Opportunitieslnk;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	public void signout() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(administratorImg).perform();
		signoutlnk.click();
	}

}
