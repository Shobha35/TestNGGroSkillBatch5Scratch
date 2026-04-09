package PageClasses;

import org.openqa.selenium.By;

public class CreateNewAppointmentPage {
	
	public static By facilityName()
	{
		return By.cssSelector("#combo_facility");
	}
	
	public static By apptDate()
	{
		return By.cssSelector("#txt_visit_date");
		
	}
	
	public static By apptDetails()
	{
		return By.cssSelector("#txt_comment");
	}
	
	public static By btnAppointment()
	{
		return By.cssSelector("#btn-book-appointment");
	}
	
	public static By validateAppt()
	{
		return By.xpath("//*[text()='Appointment Confirmation']");
	}
	
	public static By validateMsg()
	{
		return By.xpath("//p[contains(text(), 'Please')]");
	}
	public static By btnGoToHomepage() 
	{
	    return By.linkText("Go to Homepage");
	}

}
