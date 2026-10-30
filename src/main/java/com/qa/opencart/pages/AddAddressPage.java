package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class AddAddressPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public AddAddressPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	//Private Locators
	private final By FirstName=By.xpath("//input[@id='input-firstname']");
	private final By LastName= By.xpath("//input[@id='input-lastname']");
	private final By Company = By.xpath("//input[@id='input-company']");
	private final By Address1=By.xpath("//input[@id='input-address-1']");
	private final By Address2=By.xpath("//input[@id='input-address-2']");
	private final By City=By.xpath("//input[@id='input-city']");
	private final By PostCode=By.xpath("//input[@id='input-postcode']");
	private final By Country=By.xpath("//select[@id='input-country']/option"); // Xpath for list of multiple values for Country
	private final By Region_State=By.xpath("//select[@id='input-zone']/option");//Xpath for list of multiple values of Region/State
	private final By Yes_Radiobtn=By.xpath("//input[@type='radio' and @value='1']");
	private final By No_Radiobtn=By.xpath("//input[@type='radio' and @value='0']");
	private final By ContinueBtn=By.xpath("//input[@value='Continue']");
	private final By BackBtn=By.xpath("//a[text()='Back']");
	
	//Public Page Actions
	
	

}
