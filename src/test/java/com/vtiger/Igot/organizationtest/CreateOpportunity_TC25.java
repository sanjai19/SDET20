package com.vtiger.Igot.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.gereriUtility.ExcelUtility;
import com.vtiger.comcast.gereriUtility.FileUtility;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunities;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OpportunityDetail;

public class CreateOpportunity_TC25 {

		@Test
		public void CreateOpportunity() throws Throwable {
		//objects
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jav = new JavaUtility();
		FileUtility file = new FileUtility();
		ExcelUtility Ex = new ExcelUtility();
		int randomNum = jav.getRanDomNumber();
		
		String URL = file.getPropertyKeyValue("url");
		String USERNAME = file.getPropertyKeyValue("username");
        String PASSWORD = file.getPropertyKeyValue("password");
        WebDriver driver = new ChromeDriver();
        
		String oppName = Ex.getDataFromExcel("sheet1", 1, 2)+ randomNum;
		wLib.waitUntilPageLoad(driver);
        driver.get(URL);
               
        //Step1
        Login loginPage = new Login(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		
		//step2
		Home homePage = new Home(driver);
		homePage.getOpportunitieslnk().click();
		
		//step3
		CreateNewOpportunities coppPage = new CreateNewOpportunities(driver);
		coppPage.getCreateImg().click();
		
		//step4
		
				OpportunityDetail opp = new OpportunityDetail(driver);
				opp.getOpportunityName().sendKeys(oppName);
				opp.getGrpBtn().click();
				opp.GrpDDName();
				opp.SalesStage();
				opp.createImg();
				
		//step5
				homePage.signout();
	}

}
