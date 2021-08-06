package com.DollarDaysAutomation.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DollarDaysAutomation.pageObjects.FavoritesPage;
import com.DollarDaysAutomation.pageObjects.LoginPage;

public class TC_RemoveFavorites_003 extends BaseClass
{
	Logger logger = Logger.getLogger(TC_RemoveFavorites_003.class.getName());
	LoginPage lp;
	FavoritesPage fp;
	public TC_RemoveFavorites_003() 
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	public void getFavorites() 
	{
		fp=new FavoritesPage(driver);
		lp.clickSigninImage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fp.clickFavoritesLink();
		logger.info("Successfully listed the favorite items");
	}
	@Test
	public void RemoveFavorites()
	{
		//Login to portal
		lp=new LoginPage(driver);

		lp.clickSigninImage();
		lp.clickSigninLink();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Successfully logged in");

		//Redirects to Favorites page 
		getFavorites();

		//select the first item from the list to make it as un favorite
		List<WebElement> favoriteList=fp.getFavoriteList();
		String selectedItem=favoriteList.get(0).getAttribute("href");
		favoriteList.get(0).click();

		//remove an item from favorites
		fp.removeFavorite();
		logger.info("Successfully removed favorite item");

		//Redirects to Favorites page 
		getFavorites();


		//Check whether the item is delete or not from the favorites 
		List<WebElement> updatedfavoriteList=fp.getFavoriteList();
		boolean testResult=false;
		for(WebElement result:updatedfavoriteList) 
		{
			if((result.getAttribute("href")).equals(selectedItem)) 
			{
				testResult=true;
			}
		}
		if(testResult) {
			Assert.assertFalse(true);

		}else {
			Assert.assertTrue(true);
			logger.info("successfully removed the item from favorite");
		}


	}


}
