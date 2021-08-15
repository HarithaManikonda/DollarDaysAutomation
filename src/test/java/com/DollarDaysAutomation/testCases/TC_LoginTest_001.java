package com.DollarDaysAutomation.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.DollarDaysAutomation.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{
	Logger logger = Logger.getLogger(TC_LoginTest_001.class.getName());
	public TC_LoginTest_001() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test
	public void loginTest() throws IOException

	{
		LoginPage lp=new LoginPage(driver);

		lp.clickSigninImage();
		lp.clickSigninLink();
		lp.setUserName(username);
		logger.info("entered the username");
		lp.setPassword(password);
		logger.info("entered the password");
		lp.clickSubmit();
		logger.info("clicked the login button");

		if(driver.getTitle().equals("DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
