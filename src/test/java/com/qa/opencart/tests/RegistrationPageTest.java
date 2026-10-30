package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class RegistrationPageTest extends BaseTest 
{

	@BeforeClass
	public void RegistartionPageSetUp()
	{
		registratipnPage =loginPage.LoginPageclickOnRegister();
	}
	

	
	@Test
	public void getRegistrationPageTitleTest()
	{
		String actregistrationPageTitle = registratipnPage.getRegistrationPageTitle();
		Assert.assertEquals(actregistrationPageTitle, AppConstants.REGISTRATION_PAGE_TITLE);
	}
	
	@Test
	public void getRegistrationPageURLTest()
	{
		String actregistrationPageURL = registratipnPage.getRegistrationPageURL();
		Assert.assertTrue(actregistrationPageURL.contains(AppConstants.REGISTRATION_PAGE_FRACTION_URL));
	}
	
	@DataProvider
	public Object[][] getUserRegistrationData()
	{
		return new Object[][]
				{
			          {"bhagyashri","yytre", "98987431", "bhagu@8787", "yes"},
			          {"tia","yytre","9898765543", "tia@8787", "no"},
			          {"jyoti","yubvf","9898764321", "@6543", "yes"},
				};
	}
	
	@Test(dataProvider="getUserRegistrationData")
	public void userRegister(String userName, String LastName,String telephone,String emailID, String subscribe)
	{
		registratipnPage.userRegistration(userName,LastName,telephone,emailID,subscribe);
	}
	
}
