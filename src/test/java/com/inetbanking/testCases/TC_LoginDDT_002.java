package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
   @Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws Exception 
	{
	   LoginPage lp=new LoginPage(driver);
	   lp.setUsername(user);
	   logger.info("username is provided");
	   lp.setPassword(pwd);
	   logger.info("password provided");
	   lp.clickSubmit();
	   
	
   if(isAlertPresent()==true) 
   {
	   driver.switchTo().alert().accept();//close alert
	   driver.switchTo().defaultContent();
	   Assert.assertTrue(false);
	   logger.warn("login failed");
   }
	   else 
	   {
		Assert.assertTrue(true);
		logger.warn("login passed");
		Thread.sleep(3000);
		lp.clickLogout();
		driver.switchTo().alert().accept();//close logut alert
	   }
   }
	
   public boolean isAlertPresent() //This isn user defind method created to check alert is present or not
   {
	   try
	   {
	   driver.switchTo().alert();
	   return true;
	   }
	   catch (NoAlertPresentException e) 
	   {
		   return false;
	}
   }
   
   
   @DataProvider(name="LoginData")
  String[][] getData() throws IOException
   {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	  
	  int rownum=XLUtils.getRowCount(path, "Sheet1");
	  int cocount=XLUtils.getCellCount(path, "Sheet1",1);
	  String logindata[][]=new String[rownum][cocount];
	  
	  for(int i=1;i<=rownum;i++) 
	  {
		  for(int j=0;j<cocount;j++)
		  {
			logindata[i-1][j]=XLUtils.getCellData(path, "Shett1" ,i,j); //1 0
			
		  }
	  }
	  return logindata;
   }
}
