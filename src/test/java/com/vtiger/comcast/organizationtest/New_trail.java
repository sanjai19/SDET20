package com.vtiger.comcast.organizationtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class New_trail {

	WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void configBS()
	{
		reporter=new ExtentHtmlReporter("../SDET20/Extend20/SDETReports.html");
		System.out.println("Before suite executed");
		reporter.config().setDocumentTitle("SDET");
		reporter.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
	}
	@BeforeClass
	public void LaunchTheBrowser()
	{
      driver=new ChromeDriver();
      driver.get("http://localhost:8888/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
	}


	@BeforeMethod
	public void configBM() throws Throwable {
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}
			
		@Test
		public void executeHome(){
			String hme = driver.findElement(By.linkText("Home")).getText();			
		System.out.println(hme);}
		
		@Test
		public void executeOrg(){
			String drv = driver.findElement(By.linkText("Organizations")).getText();
			System.out.println(drv);}
		
		@AfterMethod
		public void logout()
		{
			Actions actions=new Actions(driver);
			{
				WebElement AdministratorLink= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				actions.moveToElement(AdministratorLink).perform();
				driver.findElement(By.linkText("Sign Out")).click();
			
			}
		}
		
		@AfterClass
		public void CloseTheBrowser()
		{
			driver.quit();
		}
		@AfterSuite
		public void configAS()
		{
			reports.flush();
			
		}
				

	}




	

