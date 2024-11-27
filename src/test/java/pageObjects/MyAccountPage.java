package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement accpage;
	
	@FindBy(xpath=("//a[@class='list-group-item'][normalize-space()='Logout']"))
	WebElement logoutbtn;
	
	public boolean accPageExists()
	{
		try
		{
			return(accpage.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void logout()
	{
		logoutbtn.click();
	}

}
