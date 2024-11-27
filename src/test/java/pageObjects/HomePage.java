package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement account;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement login;
	
	public void myAccount()
	{
		account.click();
	}
	
	public void reg()
	{
		register.click();
	}
	
	public void log()
	{
		login.click();
	}
	
}
