package com.vtiger.comcast.pomrepositylib;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpportunityDetail {
	
	 WebDriver driver;

	public OpportunityDetail(WebDriver driver) 
	{		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="potentialname")
	private WebElement OpportunityName;
	
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement GrpBtn;
	

	public WebElement getGrpBtn() {
		return GrpBtn;
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement GrpDDName;

	public WebElement getGrpDDName() {
		return GrpDDName;
	}
	
	@FindBy(name="sales_stage")
	private WebElement SalesStage;

	public WebElement getSalesStage() {
		return SalesStage;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif'][1]")
	private WebElement createImg;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunityName() {
		return OpportunityName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	
	public void GrpDDName()
	{
		Select GrpDDName = new Select(driver.findElement(By.name("assigned_group_id")));
		GrpDDName.selectByValue("2");
	}
	
	public void SalesStage()
	{
		Select SalesStage = new Select(driver.findElement(By.name("sales_stage")));
		SalesStage.selectByValue("Closed Lost");
	}
	
	public void createImg() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		createImg.click();
		Set<String> allwindowid = driver.getWindowHandles();
		for(String str:allwindowid)
		{
			driver.switchTo().window(str);
			System.out.println("url:"+driver.getCurrentUrl());
			if(driver.getCurrentUrl().equals("http://localhost:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord="))
			{
				System.out.println("Child browser");
				driver.findElement(By.xpath("//a[text()='TATA']")).click();
				break;
			}
			
			
//			driver.close();
		}
		
		driver.switchTo().window(parent);
		SaveBtn.click();
	}
	
	@FindBy(name="//a[text()='tesla']")
	private WebElement createdata;

	public WebElement getCreatedata() {
		return createdata;
	}
	
	public WebElement getCreateImg() {
		return createImg;
	}
	
		
}