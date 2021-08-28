package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.gereriUtility.ExcelUtility;
import com.vtiger.comcast.gereriUtility.FileUtility;
import com.vtiger.comcast.gereriUtility.JavaUtility;
import com.vtiger.comcast.gereriUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithSave;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithoutSave;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunities;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OpportunityDetail;

public class TC_3 {
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

	@Test
	public void withsave() throws Throwable {

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
				CreateFilterwithSave crtwithsave = new CreateFilterwithSave(driver);
				{
					crtwithsave.getSaveBtn().click();
				}
				
				//step5
				homePage.signout();

				if(driver.getCurrentUrl().equals(MainURL))
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
