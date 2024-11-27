package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	
	@Test(groups= {"Regression","Master"})
	public void logIn()
	{
		try {
			
			HomePage hp = new HomePage(driver);
			hp.myAccount();
			hp.log();
			
			
			LoginPage lp = new LoginPage(driver);
			
			lp.lem("johndoe18@gmail.com");
			lp.lpwd("qwert");
			lp.lgi();
			
			MyAccountPage myap = new MyAccountPage(driver);
			
			boolean exists = myap.accPageExists();
			
			Assert.assertEquals(exists, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
}
