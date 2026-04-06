package TestClasses;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageClasses.LogOut;
import PageClasses.LoginPage;
import Utilities.BaseClass;
import Utilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LogoutTest extends BaseClass {
	
	@Test(groups="sanity",retryAnalyzer=Utilities.RetryAnalyzerUtil.class,timeOut=10000)
	public static void logOut() throws IOException, InterruptedException
	{
		LoginTest.executeLogin();
		driver.findElement(LoginPage.hamburgerMenu()).click();
		driver.findElement(LogOut.LogOutBtn()).click();
		
	}
	
	
	
	

}
