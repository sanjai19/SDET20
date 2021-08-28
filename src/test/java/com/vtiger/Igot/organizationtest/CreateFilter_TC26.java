package com.vtiger.Igot.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.gereriUtility.ExcelUtility;
import com.vtiger.comcast.gereriUtility.FileUtility;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithoutSave;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class CreateFilter_TC26 {
		
		@Test
		public void withoutsave() throws Throwable {

					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
					WebDriverUtility wLib = new WebDriverUtility();
					JavaUtility jav = new JavaUtility();
					FileUtility file = new FileUtility();
					ExcelUtility Ex = new ExcelUtility();
					int randomNum = jav.getRanDomNumber();
					
					String URL = file.getPropertyKeyValue("url");
					String USERNAME = file.getPropertyKeyValue("username");
			        String PASSWORD = file.getPropertyKeyValue("password");
			        String MainURL = file.getPropertyKeyValue("mainurl");
			        WebDriver driver = new ChromeDriver();
			        
					String oppName = Ex.getDataFromExcel("sheet2", 0, 0)+ randomNum;
					wLib.waitUntilPageLoad(driver);
			        driver.get(URL);
			               
			        //Step1
			        Login loginPage = new Login(driver);
					loginPage.loginToApp(USERNAME, PASSWORD);
					
					//step2
					Home homePage = new Home(driver);
					homePage.getOpportunitieslnk().click();
			
					//step3
					CreateFilterwithoutSave crt = new CreateFilterwithoutSave(driver);
					crt.getCreateFilter().click();
					crt.getViewNameTF().sendKeys(oppName);
					Thread.sleep(5000);
					
		
					
					//step4
					homePage.signout();

					if(driver.getCurrentUrl().equals(MainURL))
					{
						System.out.println("Pass:without save signout done");
					}
					else
					{
						System.out.println("Fail:signout only after save");
					}
					driver.quit();

			}
		

}
