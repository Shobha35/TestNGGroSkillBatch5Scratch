package PageClasses;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By hamburgerMenu()
	{
		return By.xpath("//a[@id='menu-toggle']");
	}
	
	public static By loginBtn()
	{
		return By.xpath("//*[text()='Login']");
	}
	
	public static By userName()
	{
		return By.xpath("//input[@id='txt-username']");
	}
	
	public static By password()
	{
		return By.xpath("//input[@id='txt-password']");
	}
	
	public static By submitBtn()
	{
		return By.cssSelector("#btn-login");
	}
	
	

}
