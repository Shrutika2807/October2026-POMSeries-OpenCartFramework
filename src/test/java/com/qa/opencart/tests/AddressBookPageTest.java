package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AddressBookPageTest extends BaseTest

{
	
	@BeforeClass
	public void AddressBookPageSetUp()
	{
		 accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 addressbookPage=accPage.clickon_AddressBook();
	}
	
	@Test
	public void BackButton_IsEnabledTest()
	{
		Boolean actValue=addressbookPage.BackButton_IsEnabled();
		Assert.assertEquals(actValue,true);
	}
	
	@Test
	public void New_AdrressButton_IsEnabled()
	{
		Boolean actVal=addressbookPage.New_AdrressButton_IsEnabled();
		Assert.assertEquals(actVal,true);
	}
	
	@Test
	public void getAddressPageTitleTest()
	{
		String titleValue=addressbookPage.getAddressPageTitle();
		Assert.assertEquals(titleValue, AppConstants.ADDRESS_BOOK_TITLE);
	}
	
	@Test
	public void getAddressPageURL()
	{
		String actURLValue=addressbookPage.getAddressPageURL();
		Assert.assertEquals(actURLValue,AppConstants.ADDRESS_BOOK_URL);
	}
	
	@Test
	public void address_Book_Entries_HeaderisDisplayedTest()
	{
		Boolean actValue = addressbookPage.address_Book_Entries_HeaderisDisplayed();
		Assert.assertEquals(actValue,true);
	}

}
