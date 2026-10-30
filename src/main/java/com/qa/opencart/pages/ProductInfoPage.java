package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage 
{

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private Map<String,String> productMap;
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	//Private Locators
	private final By productHeader=By.tagName("h1");
	private final By productImages=By.cssSelector("ul.thumbnails a");
	private final By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]");
	private final By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]");
	
	//Public - Page Actions
	
	public String getProductHeader()
	{
		String productHeaderText = eleUtil.waitforElementVisible(productHeader,AppConstants.DEFAULT_TIMEOUT).getText();
		return productHeaderText;
	}
	
	public int getProductImagesCount()
	{
		int size = eleUtil.waitforAllElementsVisible(productImages,AppConstants.DEFAULT_TIMEOUT).size();
		System.out.println("Total Number of Product Images are"+" "+size);
		return size;
	}
	
	private void getProductMetaData()
	{
		 productMap= new HashMap<String,String>();
		List<WebElement> productMetaData1 = eleUtil.waitforAllElementsVisible(productMetaData, AppConstants.DEFAULT_TIMEOUT);
		
		for (WebElement e: productMetaData1)
		{
			 String MetaData=e.getText();
			 String [] meta=MetaData.split(":");
			 String metaKey=meta[0].trim();
			 String metaValue=meta[1].trim();
			 productMap.put(metaKey, metaValue);
			
			 
		}
	}
	
	private void getProductPriceData()
	{
		List<WebElement> productPricingData = eleUtil.waitforAllElementsVisible(productPriceData,AppConstants.DEFAULT_TIMEOUT);
		String productPrice=productPricingData.get(0).getText();
		String exTaxPrice=productPricingData.get(1).getText().split(":")[1].trim();
		productMap.put("productPrice",productPrice );
		productMap.put("exTaxPrice", exTaxPrice);
		
	}
	
	public Map<String, String> getProductEntireDetails()
	{
		productMap= new HashMap<String,String>();
		productMap.put("productHeader",getProductHeader());
		productMap.put("productImages",String.valueOf( getProductImagesCount()));
		getProductMetaData();
		getProductPriceData();
		System.out.println("Full Product details:"+" "+productMap);
		return productMap;
		
	}
	
}
