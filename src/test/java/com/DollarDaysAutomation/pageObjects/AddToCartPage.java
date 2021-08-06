package com.DollarDaysAutomation.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage
{
	WebDriver driver;
	public AddToCartPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="sm_menu_ham")
	WebElement menuicon;
	
	@FindBy(xpath="//*[@id='aspnetForm']/header/div[2]/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[1]/a")
	WebElement menuItemLink;
	
	@FindBy(xpath="//*[text()='Add to cart']")
	WebElement addToCartBtn;
	
	
	@FindBy(xpath="//img[@class='header-cart']")
	WebElement cartIcon;
	
	public void clickMenuIcon()
	{
		menuicon.click();
	}
	public void clickMenuItemLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='aspnetForm']/header/div[2]/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[1]/a")));
		menuItemLink.click();
	}
	public List<WebElement> getListofItems()
	{
		 List<WebElement> listOfItems=driver.findElements(By.xpath("//div[@class='prod-img']/a"));
		 return listOfItems;
	}
	
	public void clickCartIcon()
	{
	    cartIcon.click();
	}
	
	public List<WebElement> getCartItems()
	{
		 List<WebElement> listOfCartItems=driver.findElements(By.xpath("//div[@class='sku_titel']/h4/a"));
		 return listOfCartItems;
	}
	
	public void addToCartBtnClick()
	{
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		addToCartBtn.sendKeys(Keys.RETURN);
		
	}
	
	
	//*[ text() = 'Add to cart' ]

}
