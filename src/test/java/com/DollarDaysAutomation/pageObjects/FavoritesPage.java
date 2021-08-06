package com.DollarDaysAutomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPage 
{
	WebDriver driver;
	public FavoritesPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class=\"header-user\"]")
	WebElement signinImg;

	@FindBy(linkText="Favorites")
	WebElement favoritesLink;

	@FindBy(name="terms")
	WebElement searchBar;

	@FindBy(xpath="//button[@class=\"btn btn-primary btn-search dd-search\"]")
	WebElement searchButton;

	@FindBy(xpath="//div[@class='addtofvrt link bold ']")

	WebElement addToFavorites;

	@FindBy(xpath="//div[@class='rmvfromfvrt link bold ']")

	WebElement removeFavorite;

	//div[@class="jqatcform"]//input[@type="button"]
	
	
	//@FindAll(xpath="//*[@id=\"central-content\"]/div[3]/div[1]/div/div")
	//WebElement

	public void clickFavoritesLink()
	{
		favoritesLink.click();
	}

	public void clickSigninImage()
	{
		signinImg.click();
	}
	public void enterSearchText(String serchText)
	{
		searchBar.sendKeys(serchText);
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}

	public List<WebElement> getSearchResult()
	{
		List<WebElement> searchResult= driver.findElements(By.xpath("//div[@class='prod-img']/a"));//.xpath("//*[@id=\\\"central-content\\\"]/div[3]/div[1]/div/div"));
		return searchResult;
	}
	public void addToFavorites()
	{
		addToFavorites.click();
	}
	
	public void removeFavorite()
	{
		removeFavorite.click();
	}

	public List<WebElement> getFavoriteList()
	{
		List<WebElement> favoriteList= driver.findElements(By.xpath("//div[@class='prod-img']/a"));//.xpath("//*[@id=\\\"central-content\\\"]/div[3]/div[1]/div/div"));
		return favoriteList;
	}


}
