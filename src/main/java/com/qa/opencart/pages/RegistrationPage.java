package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.StringUtils;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Actions act;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		act=new Actions(driver);

	}

	// RegistrationPage-Locators

	By firstName = By.xpath("//input[@placeholder='First Name']");
	By lastName = By.xpath("//input[@name='lastname']");
	By Email = By.xpath("//input[@type='email']");
	By Telephone = By.xpath("//input[@id='input-telephone']");

	By Password = By.xpath("//input[@id='input-password']");
	By Confirm_Password = By.xpath("//input[@id='input-confirm']");

	By SubscribeYes = By.xpath("//input[@name='newsletter' and @value=1]");
	By SubscribeNo = By.xpath("//input[@name='newsletter' and @value=0]");

	By privacy_policy_checkboox = By.xpath("//input[@type='checkbox']");
	By Continue_Button = By.xpath("//input[@type='submit']");

	By succcessMesg = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	By logout_Link = By.xpath("(//a[text()='Logout'])[2]");
	By Register_Link = By.xpath("(//a[contains(text(),'Register')])[2]");

	// Public-Actions

	public String getRegistrationPageTitle() {
		String actTitle = eleUtil.waitforTitleContains(AppConstants.REGISTRATION_PAGE_TITLE,
				AppConstants.DEFAULT_TIMEOUT);
		return actTitle;
	}

	public String getRegistrationPageURL() {
		String actURL = eleUtil.waitforURLContains(AppConstants.REGISTRATION_PAGE_FRACTION_URL,
				AppConstants.DEFAULT_TIMEOUT);
		return actURL;
	}

	public boolean userRegistration(String firstname, String lastname, String telephone, String password,
			String subscribe) {
		eleUtil.waitforElementVisible(firstName, AppConstants.DEFAULT_TIMEOUT);
		eleUtil.doSendkeys(firstName, firstname);
		eleUtil.doSendkeys(lastName, lastname);
		eleUtil.doSendkeys(Email,StringUtils.getRandomEmailID());
		eleUtil.doSendkeys(Telephone, telephone);

		eleUtil.doSendkeys(Password, password);
		eleUtil.doSendkeys(Confirm_Password, password);

		if (subscribe.equalsIgnoreCase("Yes")) {
			eleUtil.doClick(SubscribeYes);
		} else {
			eleUtil.doClick(SubscribeNo);
		}

		eleUtil.doClick(privacy_policy_checkboox);
		eleUtil.doClick(Continue_Button);
		

		if (eleUtil.waitforElementVisible(succcessMesg,AppConstants.DEFAULT_TIMEOUT).getText().contains(AppConstants.SUCCESS_MESSAGE)) {
			
			eleUtil.doClick(logout_Link);
			eleUtil.doClick(Register_Link);
			eleUtil.waitforElementVisible(firstName,AppConstants.LONG_DEFAULT_TIMEOUT);
			return true;
		}

		return false;

	}

}
