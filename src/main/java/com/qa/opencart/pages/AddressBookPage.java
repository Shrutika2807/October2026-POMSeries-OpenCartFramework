package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AddressBookPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Private - WebPage Locators
	private final By New_Address_Button= By.xpath("//a[text()='New Address']");
	private final By Back_Button=By.xpath("//a[text()='Back']");
	private final By Address_Book_Entries=By.xpath("//h2[text()='Address Book Entries']");
	
	public AddressBookPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	
	//Page Actions
	
	public Boolean BackButton_IsEnabled()
	{
		return eleUtil.isElementEnabled(Back_Button);
	}
	
	public Boolean New_AdrressButton_IsEnabled()
	{
		return eleUtil.isElementEnabled(New_Address_Button);
	}
	
	public String getAddressPageTitle()
	{
		return eleUtil.waitforTitleIs(AppConstants.ADDRESS_BOOK_TITLE,AppConstants.DEFAULT_TIMEOUT);
	}
	
	public String getAddressPageURL()
	{
		return eleUtil.waitforURLIs(AppConstants.ADDRESS_BOOK_URL,AppConstants.DEFAULT_TIMEOUT);
	}
	
	public Boolean address_Book_Entries_HeaderisDisplayed()
	{
		 return eleUtil.checkElementDisplayed(Address_Book_Entries);
	}
}
