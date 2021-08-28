package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepositylib.CreateNewOpportunities;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OpportunitiesInfo;
import com.vtiger.comcast.pomrepositylib.OpportunityDetail;


public class CreateOpportunities {

	public static void main(String[] args) throws Throwable  {
		
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		//step1
		Login loginPage = new Login(driver);
		loginPage.loginToApp("admin", "admin");
		
		//step2
		Home homePage = new Home(driver);
		homePage.getOpportunitieslnk().click();
		
		//step3
		CreateNewOpportunities coppPage = new CreateNewOpportunities(driver);
		coppPage.getCreateImg().click();
		
		
		//step4
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif'][1]")).click();
		System.out.println(driver.getTitle());
		
		OpportunityDetail opp = new OpportunityDetail(driver);
		opp.getOpportunityName().sendKeys("Sanjai");
		opp.getGrpBtn().click();
		opp.GrpDDName();
		opp.SalesStage();
		opp.createImg();
				
		//step5
		OpportunitiesInfo opinfo = new OpportunitiesInfo(driver);
		System.out.println(opinfo.getsuccesfullmsg().getText());
		System.out.println(opinfo.getSuccesfullmsgTimeDate().getText());
		

		//step sign out
		homePage.signout();
		driver.quit();
	}

}
