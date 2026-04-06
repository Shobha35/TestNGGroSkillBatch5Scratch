package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageClasses.CreateNewAppointmentPage;
import Utilities.BaseClass;
import Utilities.ListenersImplementation;


@Listeners(ListenersImplementation.class)
public class CreateNewAppointmentTest extends BaseClass {
	
	@DataProvider(name="bookAppointment")
	public Object [][] dpMethod()
	{
		return new Object [][]
				{
			{"22/04/2026","Need to visit a Dentist for cavities ,its urgent"},
			{"28/04/2026","Need to visit a physician"}
				};
	}
	
	@Test(dataProvider="bookAppointment",groups="sanity",retryAnalyzer=Utilities.RetryAnalyzerUtil.class,timeOut=20000)
	public void createNewAppointment(String date,String description) throws IOException, InterruptedException
	{
		LoginTest.executeLogin();
		WebElement ele=driver.findElement(CreateNewAppointmentPage.facilityName());
		Select oselect=new Select(ele);
		oselect.selectByIndex(1);
		driver.findElement(CreateNewAppointmentPage.apptDate()).sendKeys(date);
		driver.findElement(CreateNewAppointmentPage.apptDetails()).sendKeys(description);
		driver.findElement(CreateNewAppointmentPage.btnAppointment()).click();
		Thread.sleep(2000);
		boolean flag1=driver.findElement(CreateNewAppointmentPage.validateAppt()).isDisplayed();
		boolean flag2=driver.findElement(CreateNewAppointmentPage.validateMsg()).isDisplayed();
		
		if(flag1==true && flag2==true)
		{
			System.out.println("Test Script Passed");
		}
		
		
	}
	
	
	
	

}
