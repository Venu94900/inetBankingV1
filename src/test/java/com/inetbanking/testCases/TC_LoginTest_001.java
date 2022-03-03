package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void logintest()
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered  username");
		lp.setPassword(password);
		logger.info("Entered  password");
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
           Assert.assertTrue(false);
           logger.info("Login test failed");
		}
		
		
	}
	
	
}
