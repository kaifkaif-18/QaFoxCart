package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']")
	WebElement lemail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement lpwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement lg;
	
	
	public void lem(String email)
	{
		lemail.sendKeys(email);
	}
	
	public void lpwd(String pwd)
	{
		lpwd.sendKeys(pwd);
	}
	
	public void lgi()
	{
		lg.click();
	}

}
