package com.vtiger.comcast.gereriUtility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public  class ListImpClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		
		EventFiringWebDriver Edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = Edriver.getScreenshotAs(OutputType.FILE);
		try {
		File dstFile = new File("./screenshot/.png");
		FileUtils.copyFile(srcFile, dstFile);
		}
		catch(IOException e){
		e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
