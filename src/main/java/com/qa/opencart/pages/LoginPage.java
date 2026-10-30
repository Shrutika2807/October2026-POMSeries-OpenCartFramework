package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	// 1. private WebDriver driver

	private WebDriver driver;
	private ElementUtil eleutil;

	// 2. private By locators
	private final By emailID = By.xpath("//input[@name='email']");
	private final By loginPassword = By.xpath("//input[@name='password']");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotPasswordLink = By.xpath("(//a[text()='Forgotten Password'])[1]");
	private final By registerLink=By.linkText("Register");

	// 3. public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil= new ElementUtil(driver);
	}

	// 4/ public respective page actions
	/**
	 * This function will give LoginPage Title
	 * 
	 * @return
	 */
	public String getLoginPageTitle() {
		String loginPageTitle = eleutil.waitforTitleIs(AppConstants.LOGIN_PAGE_TITLE,AppConstants.DEFAULT_TIMEOUT);
		return loginPageTitle;
	}

	/**
	 * This function will give Login Page URL
	 * 
	 * @return
	 */
	public String getLoginPageUrl() 
	{
		
		String loginpageURL = eleutil.waitforURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL,AppConstants.DEFAULT_TIMEOUT);
		return loginpageURL;

	}

	/**
	 * This function will check -"Forgot Password Link" is present inside Email ID
	 * section
	 * 
	 * @return
	 */

	public boolean isForgotPwdLinkExist() {
		 return eleutil.checkElementDisplayed(forgotPasswordLink);
		
	}

	/**
	 * This function will perform Login action with respective userName and passWord
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	
	public AccountsPage doLogin(String username, String password) 
	{
		System.out.println("Entered username and password is" + " " + username + " " + password);
		eleutil.waitforElementVisible(emailID,AppConstants.DEFAULT_TIMEOUT).sendKeys(username);
		eleutil.doSendkeys(loginPassword, password);
		eleutil.doClick(loginBtn);
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		return new AccountsPage(driver);
	}
	
	

	
	public RegistrationPage LoginPageclickOnRegister()
	{
		eleutil.waitforElementVisible(registerLink,AppConstants.DEFAULT_TIMEOUT).click();
		return new RegistrationPage(driver);
		
	}
}
