package TestClasses;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import Utilities.BaseClass;
import Utilities.FetchDataFromExcel;
import Utilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LoginTest extends BaseClass {
	
	@Test(priority=0,groups="sanity",timeOut=10000)
	
	public static void executeLogin() throws IOException, InterruptedException
	{
		driver.findElement(LoginPage.hamburgerMenu()).click();
		
		
		
		driver.findElement(LoginPage.loginBtn()).click();
		//scrollDown();
		driver.findElement(LoginPage.userName()).sendKeys(FetchDataFromExcel.getCredentials(1, 0));
		driver.findElement(LoginPage.password()).sendKeys(FetchDataFromExcel.getCredentials(1, 1));
		driver.findElement(LoginPage.submitBtn()).click();
		Thread.sleep(3000);
		Reporter.log("Login Test Case Successfull");
		
		
	}
	
	
	

}
