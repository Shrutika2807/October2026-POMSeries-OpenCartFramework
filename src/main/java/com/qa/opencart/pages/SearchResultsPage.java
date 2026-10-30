package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage 
{
	private WebDriver driver;
	
	private ElementUtil eleUtil;
	
	//Private locators
	
	private final By results_Page=By.xpath("//div[@class='product-thumb']");
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	
	//Public Page Actions
	
	
	public int getResultsProductCount()
	{
		int count = eleUtil.waitforAllElementsVisible(results_Page,AppConstants.MEDIUM_DEFAULT_TIMEOUT).size();
		System.out.println("Total Number of searched products are"+" "+count);
		return count;
		
		
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		System.out.println("Product Name is"+" "+productName);
		eleUtil.waitforElementVisible(By.linkText(productName),AppConstants.DEFAULT_TIMEOUT).click();
		return new ProductInfoPage(driver);
		
	}
	
	

}
