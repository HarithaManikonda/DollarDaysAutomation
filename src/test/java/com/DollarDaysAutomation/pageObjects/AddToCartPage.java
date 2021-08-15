package com.DollarDaysAutomation.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DollarDaysAutomation.utilities.LocatorUtils;

public class AddToCartPage {
	WebDriver driver;
	LocatorUtils locUtil = new LocatorUtils();

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "sm_menu_ham")
	WebElement menuicon;

	@FindBy(xpath = "//*[@id='aspnetForm']/header/div[2]/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[1]/a")
	WebElement menuItemLink;

	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//img[@class='header-cart']")
	WebElement cartIcon;

	@FindBy(name = "picquantity")
	WebElement noOfCases;

	@FindBy(xpath = "//input[@class='form-quantity']")
	WebElement noOfCases_cart;

	@FindBy(xpath = "//div[@class='sku_titel']/h4/a")
	List<WebElement> cartItems;

	@FindBy(xpath = "//div[@class='jqatcform']//input[@type='button']")
	List<WebElement> listOfAddToCartBtns;

	@FindBy(xpath = "//div[@class='prod-img']/a")
	List<WebElement> listOfItems;

	public void clickMenuIcon() {
		menuicon.click();
	}

	public void clickMenuItemLink() {
		if (locUtil.isElementPresent(
				By.xpath("//*[@id='aspnetForm']/header/div[2]/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[1]/a"),
				driver)) {
			menuItemLink.click();
		}

	}

	public List<WebElement> getListofItems() {
		return listOfItems;
	}

	public void clickCartIcon() {
		cartIcon.click();
	}

	public List<WebElement> getAllButtons() {
		return listOfAddToCartBtns;
	}

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public void addToCartBtnClick() {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		addToCartBtn.sendKeys(Keys.RETURN);

	}

	public void getNumberOfCases(String value) {
		noOfCases.clear();
		noOfCases.sendKeys(value);

	}

	public String getNumberOfCases_cart() {
		return noOfCases_cart.getAttribute("value");
	}

}
