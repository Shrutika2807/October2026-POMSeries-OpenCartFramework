package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void ProductInfoPageTestSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void getProductHeaderTest() {
		searchPage = accPage.doSearch("macbook");
		productInfoPage = searchPage.selectProduct("MacBook Pro");
		String actproductHeader = productInfoPage.getProductHeader();
		Assert.assertEquals(actproductHeader, "MacBook Pro");
	}
	
	
	@DataProvider
	public Object[][] getProductTestData()
	{
		return new Object[][]
				{
					{"macbook","MacBook Pro"},
					{"macbook","MacBook Air"},
					{"macbook","MacBook"},
					{"samsung","Samsung SyncMaster 941BW"},
					{"samsung","Samsung Galaxy Tab 10.1"},
					
				};
	}

	@Test(dataProvider="getProductTestData")
	public void getProductImagesCountTest(String searchKey,String productName) 
	{
		searchPage = accPage.doSearch("macbook");
		productInfoPage = searchPage.selectProduct("MacBook Air");
		int actproductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actproductImagesCount, 4);
	}
	
	@Test
	public void productInfoTest()
	{
		searchPage = accPage.doSearch("macbook");
		productInfoPage = searchPage.selectProduct("MacBook Pro");
		Map<String, String> actProductEntireDetails = productInfoPage.getProductEntireDetails();
		Assert.assertEquals(actProductEntireDetails.get("Brand"),"Apple");
		Assert.assertEquals(actProductEntireDetails.get("Product Code"),"Product 18");
		Assert.assertEquals(actProductEntireDetails.get("Availability"), "Out of Stock");
		Assert.assertEquals(actProductEntireDetails.get("productPrice"),"$2,000.00");
		Assert.assertEquals("exTaxPrice","$2,000.00");
		
		
	}
}
