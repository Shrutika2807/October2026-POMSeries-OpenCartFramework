package com.qa.opencart.constants;

import java.util.List;

public class AppConstants 
{
	
	 public static final int DEFAULT_TIMEOUT=5;
	 public static final int MEDIUM_DEFAULT_TIMEOUT=10;
	 public static final int LONG_DEFAULT_TIMEOUT=15;
	 
	 public static final String LOGIN_PAGE_TITLE="Account Login";
	 public static final String LOGIN_PAGE_FRACTION_URL="route=account/login";
	 
	 //AccountsPage
	 public static final String HOME_PAGE_TITLE="My Account";
	 public static final String HOME_PAGE_URL="https://naveenautomationlabs.com/opencart/index.php?route=account/account";
	 public static final List<String> EXPECTED_ACCOUNT_PAGE_HEADERS_LIST= List.of("My Account","My Orders","My Affiliate Account","Newsletter");
	 
	 //RegistrationPage
	 public static final List<String> EXPECTED_REGISTRATION_FORM_LIST=List.of("First Name","Last Name","E-Mail","Telephone","Yes","No");
	 public static final  String REGISTRATION_PAGE_TITLE="Register Account";
	 public static final String REGISTRATION_PAGE_FRACTION_URL="route=account/register";
	 public static final String Success_Message="Congratulations! Your new account has been successfully created!";
	 
	 
	 
	 //NewsPage Letter
	 public static final String NEWSLETTERPAGE_TITLE="Newsletter Subscription";
	 public static final String NEWSLETTERPAGE_URL="https://naveenautomationlabs.com/opencart/index.php?route=account/newsletter";
	 public static final String SUCCESS_MESSAGE=" Success: Your newsletter subscription has been successfully updated!";
	 public static final int totalNumberOptionsRightSide=13;
	 
	 //AddressBook Page
	 public static final String ADDRESS_BOOK_TITLE="Address Book";
	 public static final String ADDRESS_BOOK_URL="https://naveenautomationlabs.com/opencart/index.php?route=account/address";
}
