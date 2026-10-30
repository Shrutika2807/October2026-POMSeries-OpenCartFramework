package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.pages.SearchResultsPage;

public class SearchResultsPageTest extends BaseTest
{
	@BeforeClass
	public void searchPageSetUp()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void searchTest()
	{
		searchPage = accPage.doSearch("macbook");
		int actResultsProductCount = searchPage.getResultsProductCount();
		Assert.assertEquals(actResultsProductCount, 3);
		
	}
	
	
}
