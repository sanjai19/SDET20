package com.vtiger.comcast.gereriUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

	public class BaseClass {

		public WebDriver driver;
		public static WebDriver sDriver;
		  /*Object Creation for LIB*/
			public JavaUtility jav = new JavaUtility();
			public WebDriverUtility wLib = new WebDriverUtility();
			public FileUtility file = new FileUtility();
			public ExcelUtility Ex = new ExcelUtility();
		
		@BeforeSuite
		public void configBS() {
			System.out.println("========================connect to DB========================");
		}
		
		
		
		
		@BeforeClass
		public void configBC() {
			System.out.println("=============Launch the Browser=======");
			driver = new ChromeDriver();
			wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();}
			
			
			
		
		@BeforeMethod
		public void configBM() throws Throwable {
			/*common Data*/
			String USERNAME = file.getPropertyKeyValue("username");
			String PASSWORD = file.getPropertyKeyValue("password");
			String URL = file.getPropertyKeyValue("url");
			//String BROWSER = file.getPropertyKeyValue("browser");
			/* Navigate to APP*/
			   driver.get(URL);
		        /* step 1 : login */
		        Login loginPage = new Login(driver);
		        loginPage.loginToApp(USERNAME, PASSWORD);
		}
		
		
		
		
		@AfterMethod
		public void configAM() {
		      /*step 6 : logout*/
			Home homePage = new Home(driver);
	        homePage.signout();
		}
		
		@AfterClass
		public void configAC() {
			System.out.println("=============Close the Browser=======");
			driver.quit();
		}
		
		@AfterSuite
		public void configAS() {
			System.out.println("========================close DB========================");
		}

}
