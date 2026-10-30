package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;

	private ElementUtil eleUtil;

	// private by locators

	private final By myaffliateAccount = By.xpath("//a[text()='Register for an affiliate account']");
	private final By header = By.cssSelector("div#content>h2");
	private final By searchField = By.xpath("//input[@name='search']");
	private final By search_Icon = By.xpath("//span[@class='input-group-btn']/button[@type='button']");
	private final By News_Letter = By.linkText("Newsletter");
	private final By Address_Book=By.xpath("//a[text()='Address Book']");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		String accPageTitle = eleUtil.waitforTitleIs(AppConstants.HOME_PAGE_TITLE, AppConstants.DEFAULT_TIMEOUT);
		System.out.println("Account page title is" + " " + accPageTitle);
		return accPageTitle;

	}

	public String getAccountPageURL() {
		String accPageURL = eleUtil.waitforURLIs(AppConstants.HOME_PAGE_URL, AppConstants.DEFAULT_TIMEOUT);
		System.out.println("Account Page URL is" + " " + accPageURL);
		return accPageURL;

	}

	public Boolean toCheck_MyAccountAffliateOnAccountsPageIsDisplayed() {
		Boolean val = eleUtil.isElementDisplayed(myaffliateAccount);
		System.out.println("Affliate On Accounts Page is Displayed" + " " + val);
		return val;
	}

	public List<String> toCheckAccountPageHeaders() {
		List<WebElement> headerList = eleUtil.getElements(header);
		System.out.println("Total number of headers on Account Page are" + " " + headerList.size());
		List<String> headerValList = new ArrayList<String>();
		for (WebElement e : headerList) {
			String text = e.getText();
			headerValList.add(text);

		}

		return headerValList;
	}

	public SearchResultsPage doSearch(String searchKey) {

		System.out.println("Search Key is" + " " + searchKey);
		eleUtil.waitforElementVisible(searchField, AppConstants.DEFAULT_TIMEOUT);
		eleUtil.doSendkeys(searchField, searchKey);
		eleUtil.doClick(search_Icon);
		return new SearchResultsPage(driver);
	}

	public NewsLetterPage clickOnNewsLetter() {
		WebElement news_Letter = eleUtil.waitforElementVisible(News_Letter, AppConstants.DEFAULT_TIMEOUT);
		news_Letter.click();
		return new NewsLetterPage(driver);

	}
	
	
	public AddressBookPage clickon_AddressBook()
	{
		eleUtil.doClick(Address_Book);
		return new AddressBookPage(driver);
	}

}
