package TestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.gereriUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithSave;
import com.vtiger.comcast.pomrepositylib.CreateFilterwithoutSave;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunities;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.OpportunityDetail;
@Listeners(com.vtiger.comcast.gereriUtility.ListImpClass.class)
public class AssertCallTest  extends BaseClass {
	 
		@Test(groups= {"SmokeTesting"})
		public void CreateOpportunity() throws Throwable {
		//objects
		
		int randomNum = jav.getRanDomNumber();
		   
		String oppName = Ex.getDataFromExcel("sheet1", 1, 2)+ randomNum;
	     
	    	
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
		
	}
		
		
		@Test(groups= {"RegressionTesting"})
		public void withoutsave() throws Throwable {

					
					int randomNum = jav.getRanDomNumber();
					
			        String MainURL = file.getPropertyKeyValue("mainurl1");
			        
			        
					String oppName = Ex.getDataFromExcel("sheet2", 0, 0)+ randomNum;
				
					//step2
					Home homePage = new Home(driver);
					homePage.getOpportunitieslnk().click();
			
					//step3
					CreateFilterwithoutSave crt = new CreateFilterwithoutSave(driver);
					crt.getCreateFilter().click();
					crt.getViewNameTF().sendKeys(oppName);
					Thread.sleep(5000);
				

					

					String Actuall = "driver.getCurrentUrl()";
					
					SoftAssert s = new SoftAssert();
					s.assertEquals(Actuall, MainURL);
					s.assertAll();
					
					//Assert.assertEquals(Actuall, MainURL);
					
			}

		@Test(groups= {"RegressionTesting,SmokeTesting"})
		public void withsave() throws Throwable {

					
					int randomNum = jav.getRanDomNumber();
									
			        String MainURL2 = file.getPropertyKeyValue("mainurl2");
			        		        
					String oppName = Ex.getDataFromExcel("sheet2", 0, 0)+ randomNum;
				
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
				
					
					String Actually = "driver.getCurrentUrl()";
					Assert.assertEquals(Actually, MainURL2);

			}
	

}
