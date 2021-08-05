package com.DollarDaysAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class=\"header-user\"]")
	WebElement signinImg;
	
	@FindBy(linkText="Sign In")
	WebElement signinLink;
	
	@FindBy(linkText="Favorites")
	WebElement favoritesLink;
	
	@FindBy(name="username")
	WebElement txtUserName;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(xpath="//button[@class=\"btn\"]")
	WebElement btnLogin;


	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
//	public void clickLogout()
//	{
//		lnkLogout.click();
//	}
//
//@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
//WebElement lnkLogout;
//
	public void clickSigninImage()
	{
		signinImg.click();
	}
	public void clickSigninLink()
	{
		signinLink.click();
	}
	public void clickFavoritesLink()
	{
		favoritesLink.click();
	}

}
