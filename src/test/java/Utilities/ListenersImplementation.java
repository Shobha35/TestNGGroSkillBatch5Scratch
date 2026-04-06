package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import ConstantsData.ConstantData;

public class ListenersImplementation extends BaseClass implements ITestListener 
{

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println("Test Case Started");
		Reporter.log("Opening Browser for Test Execution ");
		
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Case Successfull");
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test Case failed---->Taking Screenshot");
		TakesScreenshot srcshot=(TakesScreenshot)driver;
		File srcFile=srcshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(ConstantData.FAILED_SCREENSHOT_PATH);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ScreenShot captured");
		
		
		
		
		
		
		
		
	}

}
