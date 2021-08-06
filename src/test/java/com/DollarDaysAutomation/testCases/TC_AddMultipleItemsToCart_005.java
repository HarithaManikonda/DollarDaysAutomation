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

public class TC_AddMultipleItemsToCart_005 extends BaseClass
{
	Logger logger = Logger.getLogger(TC_AddFavorites_002.class.getName());
	LoginPage lp;
	WebDriverWait wait;
	public TC_AddMultipleItemsToCart_005() 
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

		// get the first two elements href

		String selectedItem1= listOfItems.get(0).getAttribute("href");

		String selectedItem2= listOfItems.get(1).getAttribute("href");
		
		logger.info("first selecte item is - > "+selectedItem1);
		logger.info("second selecte item is - > "+selectedItem2);

		// get all the buttons click the first one through quick add

		addToCart.getAllButtons().get(0).click();
		wait = new WebDriverWait(driver, 10);

		// add the second item through normal click

		listOfItems.get(1).click();

		// updating the no of cases to 2 
		String noofcases="2";
		addToCart.getNumberOfCases("2");
		wait = new WebDriverWait(driver, 10);

		//Adding item to the cart
		addToCart.addToCartBtnClick();
		logger.info("Sucessfully item added to the cart");


		//Click on cart icon
		addToCart.clickCartIcon();
		wait = new WebDriverWait(driver, 10);
		logger.info("Successfully click on cart icon");

		//Getting all the items in the cart
		boolean result1=false;
		boolean result2=false;
		List<WebElement> listOfCartItems=addToCart.getCartItems();
		for(WebElement element:listOfCartItems)

		{
			//checking if the first item is part of cart
			if(element.getAttribute("href").equals(selectedItem1)) {
				result1=true;
			}	
			//checking if the second item is part of cart and no of cases match
			if(element.getAttribute("href").equals(selectedItem2) && noofcases.equals(addToCart.getNumberOfCases_cart())) {
				result2=true;
			}

		}
			    if(result1 && result2) {
			    	Assert.assertTrue(true);
			    	 logger.info("Testcase executed successfully");
			    	 
			    }
			    else
			    	Assert.assertFalse(true);


	}
}
