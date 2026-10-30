package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class NewsLetterPage

{

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators

	private final By NewsLetter_Subscription_Header = By.xpath("//div[@id='content']/h1");
	private final By Subscriber_Label = By.xpath("//label[text()='Subscribe']");
	private final By Raido_Button_Yes_No = By.xpath("//label[@class='radio-inline']//input");
	private final By Continue_Button= By.xpath("//input[@value='Continue']");
	private final By Yes_RadioButton=By.xpath("//input[@value='1']");
	private final By No_RadioButton=By.xpath("//input[@value='0']");
	private final By Success_Message= By.xpath("//div[contains(text(),'subscription')]");
	private final By Subscribe_unsubscribetonewsletter=By.xpath("//a[contains(text(),'unsubscribe')]");
	private final By Back_Button=By.xpath("//a[text()='Back']");
	private final By totalOptions=By.xpath("//div[@class='list-group']/a");

	public NewsLetterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String get_NewsLetterPageTitle() {
		String newsletterpage_Title = eleUtil.waitforTitleIs(AppConstants.NEWSLETTERPAGE_TITLE,
				AppConstants.LONG_DEFAULT_TIMEOUT);
		return newsletterpage_Title;

	}

	public String get_NewsLetterPageURL() {
		String newsPageUrl = eleUtil.waitforURLIs(AppConstants.NEWSLETTERPAGE_URL, AppConstants.DEFAULT_TIMEOUT);
		return newsPageUrl;
	}

	public boolean get_NewsLetterHeaderIsDisplayed() {
		boolean headerDisplayed = eleUtil
				.waitforElementVisible(NewsLetter_Subscription_Header, AppConstants.DEFAULT_TIMEOUT).isDisplayed();
		return headerDisplayed;
	}

	public boolean toCheckSubscriberLabelIsDisplayed() {
		boolean subscribe_displayed = eleUtil.waitforElementVisible(Subscriber_Label, AppConstants.DEFAULT_TIMEOUT)
				.isDisplayed();
		return subscribe_displayed;
	}



	public boolean toCheck_ContinueButton_IsDisplayed() 
	{
			return eleUtil.waitforElementVisible(Continue_Button,AppConstants.DEFAULT_TIMEOUT).isDisplayed();
	}

	public boolean toCheck_ContinueButton_IsEnabled() 
	{
			 return eleUtil.isElementEnabled(Continue_Button);
	}

	public String toCheck_SuccessMessage_getsDisplayed_onYesSubscription() 
	{
		eleUtil.doClick(Yes_RadioButton);
		eleUtil.doClick(Continue_Button);
		WebElement SuccessMesg=eleUtil.getElement(Success_Message);
		String mesg=SuccessMesg.getText();
		System.out.println("Success Message is"+" "+mesg);
		return mesg;
		
	}

	public void doClickOnSubscribe_UnSubscribe()
	
	{
		eleUtil.waitforElementVisible(Subscribe_unsubscribetonewsletter,AppConstants.LONG_DEFAULT_TIMEOUT);
		eleUtil.doClick(Subscribe_unsubscribetonewsletter);
	}
	public boolean backButton_isEnabled() 
	{
            return eleUtil.isElementEnabled(Back_Button);  
	}

	public boolean backButton_isDisplayed() {
		return eleUtil.checkElementDisplayed(Back_Button);

	}

	public void userClicksOnBackButton() {
		eleUtil.doClick(Back_Button);
	}

	public int verifyTotalNumberOfNewsletterPageOptionsDisplayed_OnRightSide() {
		
		List<WebElement> options = eleUtil.getElements(totalOptions);
		int totalele=options.size();
		return totalele;
	}

}
