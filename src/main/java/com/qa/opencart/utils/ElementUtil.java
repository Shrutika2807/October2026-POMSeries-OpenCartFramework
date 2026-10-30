package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	
	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public void doSendkeys(By locator, String value) {
		nullCheck(value);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void doSendkeys(By locator, CharSequence... value) {
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) 
	{
		getElement(locator).click();
	}

	public String doElementgetText(By locator) {
		String eleText = getElement(locator).getText();
		System.out.print("Text of the Element is" + ":" + eleText);
		return eleText;
	}

	public String getElementDOMattributeValue(By locator, String value) {
		nullCheck(value);
		String domAttributeValue = getElement(locator).getDomAttribute(value);
		System.out.println("DOM attribute value is" + ":" + domAttributeValue);
		return domAttributeValue;
	}

	public String getElementDOMPropertyValue(By locator, String value) {
		nullCheck(value);
		String domPropertyValue = getElement(locator).getDomProperty(value);
		System.out.println("Property of Element is" + ":" + domPropertyValue);
		return domPropertyValue;
	}

	/**
	 * This Function represents,whether an element is present on the page and
	 * whether it is displayed.
	 * 
	 * @param locator
	 * @return
	 */
	public Boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Element is not present on the page");
			return false;
		}
	}

	public Boolean isElementEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public Boolean isElementSelected(By locator) {
		return getElement(locator).isSelected();
	}

	private void nullCheck(CharSequence... value) {

		if (value == null) {
			throw new RuntimeException("==Value cannot be NULL==");
		}
	}

	// ***************************Find-Elements-Utils***************************//

	/**
	 * This Function is used to get Multiple Elements using findElements Method
	 * 
	 * @param locator
	 * @return
	 */

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * This Function is used to get the count of the Elements
	 * 
	 * @param locator
	 * @return
	 */
	public int getElementsCount(By locator) {
		int elementCount = getElements(locator).size();
		System.out.println("Element count is" + ":" + elementCount);
		return elementCount;
	}

	/**
	 * This Function is used to get the text of multiple Elements
	 * 
	 * @param locator
	 * @return
	 */

	public List<String> getElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				eleTextList.add(text);
			}
		}

		return eleTextList;
	}

	/**
	 * his function is used to find and click an element from a list of web elements
	 * based on the given text value.
	 * 
	 * @param locator
	 * @param value
	 */
	public void clickElement(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println(eleList);
		System.out.println("Total Number of languages on Google page are" + ":" + eleList.size());
		for (WebElement lang : eleList) {
			String languageText = lang.getText();
			System.out.println(languageText);
			if (languageText.contains(value)) {
				lang.click();
				break;
			}

		}

	}

	/**
	 * This Function is used to check the element if it is getting displayed or not
	 * on web page for count 1
	 * 
	 * @param locator
	 * @return
	 */

	public Boolean checkElementDisplayed(By locator) {
		if (driver.findElements(locator).size() == 1) {
			System.out.println("Element" + locator + "is displayed on the page one time");
			return true;
		}
		return false;
	}

	/**
	 * This Function is used to check the element if it is getting displayed or not
	 * on web page for the given count
	 * 
	 * @param locator
	 * @param value
	 * @return
	 */
	public Boolean checkElementDisplayed(By locator, int value) {
		if (driver.findElements(locator).size() == value) {
			System.out.println("Element" + locator + "is displayed on page for" + value + "times");
			return true;
		}
		return false;
	}

	// ************************************Drop-Down-Utils*****************************************************//

	public Boolean doSelectDropDownByIndex(By locator, int value) {

		Select select = new Select(getElement(locator));
		try {
			select.selectByIndex(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out
					.println("The value that you have entered is incorrect" + value + "Please pass the correct value");
			return false;
		}
	}

	public Boolean doSelectDropDownByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out
					.println("The value that you have entered is incorrect" + value + "Please pass the correct value");
			return false;
		}
	}

	public Boolean doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out
					.println("The value that you have entered is incorrect" + value + "Please pass the correct value");
			return false;
		}
	}

	// **************************************Action-Class-Utils********************************************//

	public void doMovetoElement(By locator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).build().perform();
		Thread.sleep(2000);
	}

	public void handleParentSubMenu(By parentMenu, By subMenu) throws InterruptedException {
		doMovetoElement(parentMenu);
		doClick(subMenu);

	}

	public void handle4LevelMenuHandle(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {
		doClick(level1Menu);
		Thread.sleep(2000);
		doMovetoElement(level2Menu);
		Thread.sleep(2000);
		doMovetoElement(level3Menu);
		Thread.sleep(2000);
		doClick(level4Menu);
	}

	/**
	 * This function will do click operation using Actions class
	 * 
	 * @param locator
	 */
	public void doActionsClick(By locator) {

		act.click(getElement(locator)).build().perform();
	}

	/**
	 * This function is used perform sendKeys operation using Actions class
	 * 
	 * @param locator
	 * @param value
	 */

	public void doActionsSendKeys(By locator, String value) {

		act.sendKeys(getElement(locator), value).build().perform();

	}

	/**
	 * This function is used to send the keys with some "PAUSE"
	 * 
	 * @param locator
	 * @param value
	 * @param pauseTime
	 */
	public void doSendKeysWithPause(By locator, String value, long pauseTime) {

		char[] ch = value.toCharArray();

		for (char ch1 : ch) {
			act.sendKeys(getElement(locator), String.valueOf(ch1)).pause(pauseTime).build().perform();

		}

	}

	// ********************************************Wait-Utils-Of-Elements*******************************************************//
	/**
	 * This function represent, An expectation for checking that an element is
	 * present on the DOM of a page. This does not necessarily mean that the element
	 * is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * This function represents,"An expectation for checking that there is at least
	 * one element present on a web page."
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public List<WebElement> waitForAllElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	/**
	 * This function represents ,an expectation for checking that an element is
	 * present on the DOM of a page and visible. Visibility means that the element
	 * is not only displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitforElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	/**
	 * This Function is to represent : An expectation for checking that all elements
	 * present on the web page that match the locator are visible. Visibility means
	 * that the elements are not only displayed but also have a height and width
	 * that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public List<WebElement> waitforAllElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try
		{
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		catch(TimeoutException e)
		{
			return Collections.emptyList();
		}
	}

	/**
	 * This function is used to click on the WebElement with some wait
	 * 
	 * @param locator
	 * @param timeOut
	 */

	public void clickWithWait(By locator, int timeOut) {
		waitforElementVisible(locator, timeOut).click();
	}

	/**
	 * This function represents to send the keys with some wait
	 * 
	 * @param locator
	 * @param timeOut
	 * @param value
	 */

	public void sendKeysWithWait(By locator, int timeOut, String value) {
		waitforElementVisible(locator, timeOut).sendKeys(value);
	}

	// *************************************Alert-Utils************************************************//

	/**
	 * This function represent to wait for alert and also it will switch to the
	 * alert
	 * 
	 * @param timeOut
	 * @return
	 */

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	/**
	 * This function will accept the alert
	 * 
	 * @param timeOut
	 */

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	/**
	 * This function will dismiss the alert
	 * 
	 * @param timeOut
	 */

	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	/**
	 * This function will get the text from the alert
	 * 
	 * @param timeOut
	 * @return
	 */

	public String getTextAlert(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	/**
	 * This function will perform do send keys
	 * 
	 * @param timeOut
	 * @param value
	 */
	public void sendKeysAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

	// ************************************Wait-for-title**********************************************//

	public String waitforTitleContains(String value, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(value));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;

		}

	}

	public String waitforTitleIs(String value, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(value));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;
		}
	}

	// ***********************************Wait-for-URL******************************************************//

	public String waitforURLContains(String value, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(value));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			return null;
		}
	}

	public String waitforURLIs(String value, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlToBe(value));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			return null;
		}

	}

	// ********************************************Wait-for-Frame-Util************************************************//

	public void waitForFrameandSwitchToIt(By framelocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}

	public void waitForFrameandSwitchToIt(String frameIdorValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdorValue));
	}

	public void waitForFrameandSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameandSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	// ************************************Wait-Util-Window*********************************//

	public boolean waitForWindow(int ExpectedNumberofWindowsToBe, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(ExpectedNumberofWindowsToBe));
			return true;
		} catch (Exception e) {
			System.out.println("Expected Number of Windows are incorrect");
			return false;
		}
	}

	public void clickWhenReadyt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	// ***********************************Fluent-Wait-Util*************************************//
	
	/**
	 * This function represent - fluentWait
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */

	public WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage("Element is nOt Found on the Page");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage("Element is nOt Found on the Page");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
		

}
