package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import static com.qa.opencart.constants.AppConstants.*;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String accountPageTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(accountPageTitle,HOME_PAGE_TITLE);

	}

	@Test
	public void getAccountPageURLTest() {
		String accountPageURL = accPage.getAccountPageURL();
		Assert.assertEquals(accountPageURL,HOME_PAGE_URL);
	}

	@Test
	public void toCheck_MyAccountAffliateOnAccountsPageIsDisplayedTest() {
		Boolean check_MyAccountAffliateOnAccountsPageIsDisplayed = accPage
				.toCheck_MyAccountAffliateOnAccountsPageIsDisplayed();
		Assert.assertEquals(check_MyAccountAffliateOnAccountsPageIsDisplayed, true);
	}
	
	
	@Test
	public void toCheckAccountPageHeadersTest()
	{
		      List<String> actualHeaderList = accPage.toCheckAccountPageHeaders();
		      Assert.assertEquals(actualHeaderList,EXPECTED_ACCOUNT_PAGE_HEADERS_LIST);
		      
	}
}
