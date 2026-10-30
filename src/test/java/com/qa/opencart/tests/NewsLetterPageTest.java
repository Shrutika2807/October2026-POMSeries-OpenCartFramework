package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class NewsLetterPageTest extends BaseTest {
	@BeforeClass
	public void newsLetterPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void get_NewsLetterPageTitle_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		String get_NewsLetterPageTitle = newsletterPage.get_NewsLetterPageTitle();
		Assert.assertEquals(get_NewsLetterPageTitle, "Newsletter Subscription");

	}

	@Test
	public void get_NewsLetterPageURL_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		String get_NewsLetterPageURL = newsletterPage.get_NewsLetterPageURL();
		Assert.assertEquals(get_NewsLetterPageURL,
				"https://naveenautomationlabs.com/opencart/index.php?route=account/newsletter");
	}

	@Test
	public void get_NewsLetterHeaderIsDisplayed_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean headerDisplayed = newsletterPage.get_NewsLetterHeaderIsDisplayed();
		Assert.assertEquals(headerDisplayed, true);
	}

	@Test
	public void toCheckSubscriberLabelIsDisplayed_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean labelDisplayed = newsletterPage.toCheckSubscriberLabelIsDisplayed();
		Assert.assertEquals(labelDisplayed, true);

	}

	@Test
	public void toCheck_ContinueButton_IsDisplayed_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean continuebuttonDisplayed = newsletterPage.toCheck_ContinueButton_IsDisplayed();
		Assert.assertEquals(continuebuttonDisplayed, true);
	}

	@Test
	public void toCheck_ContinueButton_IsEnabled_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean continuebuttonEnabled = newsletterPage.toCheck_ContinueButton_IsEnabled();
		Assert.assertEquals(continuebuttonEnabled, true);

	}

	@Test
	public void toCheck_SuccessMessage_getsDisplayed_onYesSubscription_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		String successMessage = newsletterPage.toCheck_SuccessMessage_getsDisplayed_onYesSubscription();
		Assert.assertEquals(successMessage, "Success: Your newsletter subscription has been successfully updated!");
	}

	@Test
	public void doClickOnSubscribe_UnSubscribe_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		newsletterPage.doClickOnSubscribe_UnSubscribe();
	}

	@Test
	public void backButton_isEnabled_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean buttonEnabled = newsletterPage.backButton_isEnabled();
		Assert.assertEquals(buttonEnabled, true);
	}

	@Test
	public void backButton_isDisplayed_Test() {
		newsletterPage = accPage.clickOnNewsLetter();
		boolean buttonDisabled = newsletterPage.backButton_isDisplayed();
		Assert.assertEquals(buttonDisabled, true);

	}
	
	@Test
	public void userClicksOnBackButton_Test()
	{
		newsletterPage = accPage.clickOnNewsLetter();
		newsletterPage.userClicksOnBackButton();
	}
	
	@Test
	public void verifyTotalNumberOfNewsletterPageOptionsDisplayed_OnRightSide_Test()
	{
		newsletterPage = accPage.clickOnNewsLetter();
		int totalOptions=newsletterPage.verifyTotalNumberOfNewsletterPageOptionsDisplayed_OnRightSide();
		Assert.assertEquals(totalOptions,AppConstants.totalNumberOptionsRightSide);
	}

}