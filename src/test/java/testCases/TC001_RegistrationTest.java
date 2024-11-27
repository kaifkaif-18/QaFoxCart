package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass{

	
	@Test(groups= {"Sanity","Master"})
	public void registartion()
	{
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Registration started");
			
			hp.myAccount();
			hp.reg();
			
			
			RegistrationPage rg = new RegistrationPage(driver);
			logger.info("Registration started");
			
			rg.fstnme(randomf());
			rg.lstnme(randoml());
			rg.emails(randome()+"@gmail.com");
			rg.teles(randomt());
			
			String pwd = randomp();
			rg.pass(pwd);
			rg.cpass(pwd);
			rg.tc();
			rg.conti();
			
			logger.info("Registartion done");
			
			String con = rg.msg();
			System.out.println(con);
			Assert.assertEquals(con, "Your Account Has Been Created!");
			
			logger.info("Test successful");
		}
		catch(Exception e)
		{
			logger.info("Test Failed");
			Assert.fail();
		}
	
	}
}
