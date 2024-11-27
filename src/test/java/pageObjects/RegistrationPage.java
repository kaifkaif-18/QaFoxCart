package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement tele;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cpassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont;

	@FindBy(xpath="//div[@id='content']//h1") WebElement confirm;
	
	
	
	
	
	public void fstnme(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void lstnme(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void emails(String e)
	{
		email.sendKeys(e);
	}
	public void teles(String t)
	{
		tele.sendKeys(t);
	}
	public void pass(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void cpass(String pwd)
	{
		cpassword.sendKeys(pwd);
	}
	public void tc()
	{
		agree.click();
	}
	public void conti()
	{
		cont.click();
	}

	public String msg()
	{
		try
		{
			return (confirm.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}








