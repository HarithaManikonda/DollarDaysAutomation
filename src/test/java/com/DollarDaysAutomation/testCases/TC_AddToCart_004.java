package com.DollarDaysAutomation.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DollarDaysAutomation.pageObjects.AddToCartPage;
import com.DollarDaysAutomation.pageObjects.LoginPage;

public class TC_AddToCart_004 extends BaseClass
{
	Logger logger = Logger.getLogger(TC_AddFavorites_002.class.getName());
	LoginPage lp;
	public TC_AddToCart_004() 
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	@Test
	public void AddToCart()
	{
		//Login to portal
		lp=new LoginPage(driver);
		lp.clickSigninImage();
		lp.clickSigninLink();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Successfully logged in");
		
		//Click on menu icon
		AddToCartPage addToCart=new AddToCartPage(driver);
		addToCart.clickMenuIcon();
		logger.info("menu icon click done");

		//Clicks on Mask,Sanitizer and PPE tab under Now trending tab
		addToCart.clickMenuItemLink();
		//gets the list of items in that selected category
		List<WebElement> listOfItems=addToCart.getListofItems();
		
		//Selecting the first item and redirecting to item page
	
		String selectedItem= listOfItems.get(0).getAttribute("href");
		listOfItems.get(0).click();
		
		
		//Adding item to the cart
		addToCart.addToCartBtnClick();
		logger.info("Sucessfully item added to the cart");
		
		//Click on cart icon
        addToCart.clickCartIcon();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Successfully click on cart icon");
		
		//Getting all the items in the cart and 
		boolean result=false;
		List<WebElement> listOfCartItems=addToCart.getCartItems();
		for(WebElement element:listOfCartItems)
		{
			//checking if the added item is part of cart
			if(element.getAttribute("href").equals(selectedItem)) {
				result=true;
				break;
			}	
				
		}
	    if(result) {
	    	Assert.assertTrue(true);
	    	 logger.info("Testcase executed successfully");
	    }
	    else
	    	Assert.assertFalse(true);
	   
	
	}
}
