package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Feature("Login Page Functionality")
@Epic("Epic 100 :design pages for open cat application")
@Story("US 101: Implement Login Page functionalty for Open cart Application")
public class LoginPageTest extends BaseTest 
{
	@Severity(SeverityLevel.MINOR)
	@Description("To get Login Page Title")
	@Owner("SHRUTIKA")
	@Test(priority = 1)
	@Step("Checking the Login Page Title")
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test(priority = 3)
	public void isForgotPwdLinkExistTest() {
		Boolean forgotpwdLink = loginPage.isForgotPwdLinkExist();
		Assert.assertEquals(forgotpwdLink, true);
	}
	@Description("User is able to login with valid username and password")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void doLoginTest() {
		AccountsPage accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountsPage.getAccountPageTitle(), AppConstants.HOME_PAGE_TITLE);
	}

}
