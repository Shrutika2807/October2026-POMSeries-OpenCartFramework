package com.qa.opencart.BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.AddressBookPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.NewsLetterPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.utils.Log4JUtil;

@Listeners(ChainTestListener.class)
public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchPage;
	protected ProductInfoPage productInfoPage;
	protected RegistrationPage registratipnPage;
	protected NewsLetterPage newsletterPage;
	protected AddressBookPage addressbookPage;

	
	@BeforeTest
	public void setUp() 
	{
		df =new DriverFactory();
		prop=df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext result)
	{
		Log4JUtil.info("Starting test case"+result.getName());
	}
	
	
	@AfterMethod
	public void attachScreenshot(ITestResult result)
	{
		if(!result.isSuccess())
		{
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}
		
		Log4JUtil.info("Ending Test Case");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
