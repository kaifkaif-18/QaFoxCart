package testCases;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="LogInData",dataProviderClass=DataProviders.class,groups="DatDriven")
	public void logInDataDriven(String email,String pwd, String exp)
	{
		logger.info("Test started");
		try 
		{
			HomePage hp = new HomePage(driver);
			
			logger.info("Clicked on My Account");
			hp.myAccount();
			
			logger.info("Clicked on Login");
			hp.log();
			
			
			LoginPage lp = new LoginPage(driver);
			
			logger.info("Started entering login details");
			lp.lem(email);
			lp.lpwd(pwd);
			lp.lgi();
			
			MyAccountPage myap = new MyAccountPage(driver);
			
			boolean exists = myap.accPageExists();
			logger.info("Page Exists");
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(exists==true)
				{
					myap.logout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(exists==true)
				{
					myap.logout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occured: "+e.getMessage());
		}
	}
}
