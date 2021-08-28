package TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.gereriUtility.BaseClass;

public class Screenshot extends BaseClass {

	@Test
	
	public void verifyopp() throws Throwable
	{	
	
	EventFiringWebDriver Edriver = new EventFiringWebDriver(driver);
	File srcFile = Edriver.getScreenshotAs(OutputType.FILE);
	File dstFile = new File("./screenshot/"+"name"+".png");
	FileUtils.copyFile(srcFile, dstFile);
	
		
	}
	
}
