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

public class TC_AddFavorites_002 extends BaseClass
{
	Logger logger = Logger.getLogger(TC_AddFavorites_002.class.getName());
	public TC_AddFavorites_002() 
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	@Test
	public void AddFavorites()

	{
		//Login to portal
		LoginPage lp=new LoginPage(driver);

		lp.clickSigninImage();
		lp.clickSigninLink();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Successfully logged in");

		//Search for items
		FavoritesPage fp=new FavoritesPage(driver);
		fp.enterSearchText("baby dress");
		fp.clickSearchButton();
		logger.info("Successfully searched the items");

		// get search results and click and first item
		List<WebElement> searchResult=fp.getSearchResult();
		String favoriteItem=searchResult.get(0).getAttribute("href");
		searchResult.get(0).click();
		logger.info("Opened the items to add it to favorites");

		// add the item to favorites
		fp.addToFavorites();
		logger.info("Item successfully added to favorites");

		// click on sign in image and favorite

		lp.clickSigninImage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fp.clickFavoritesLink();
		logger.info("Successfully listed the favorite items");

		//compare selected favorite with all items in the favorites
		List<WebElement> favoriteList=fp.getFavoriteList();
		boolean testResult=false;
		for(WebElement result:favoriteList) 
		{
			if((result.getAttribute("href")).equals(favoriteItem)) 
			{
				logger.info("Favorite added successfully");
				testResult=true;
				break;
			}
		}
		if(testResult) {
			Assert.assertTrue(true);
			
		}else {
			Assert.assertFalse(true);
		}
	}

}
