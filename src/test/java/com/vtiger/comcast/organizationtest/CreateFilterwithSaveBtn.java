package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepositylib.CreateFilterwithSave;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithoutSave;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class CreateFilterwithSaveBtn {

	
		public static void main(String[] args) throws Throwable {
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
			CreateFilterwithoutSave crt = new CreateFilterwithoutSave(driver);
			crt.getCreateFilter().click();
			crt.getViewNameTF().sendKeys("india");
			Thread.sleep(5000);
			
			//step4
			CreateFilterwithSave crtwithsave = new CreateFilterwithSave(driver);
			{
				crtwithsave.getSaveBtn().click();
			}
			
			//step5
			homePage.signout();

			if(driver.getCurrentUrl().equals("http://localhost:8888/index.php?action=Login&module=Users"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			driver.quit();

	}

}
