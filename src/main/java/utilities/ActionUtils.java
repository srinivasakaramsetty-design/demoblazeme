package utilities;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	private static final Logger log = LogManager.getLogger(ActionUtils.class);

	public ActionUtils(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void acceptAlert() {
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}

	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	public void click(WebElement element) 
	{
		try 
		{
			waitForClickable(element).click();
		}
		catch (StaleElementReferenceException e)
		{
			log.warn("Stale element detected, retrying click");
			waitForClickable(element).click();
		}
	}

	public void click(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			log.info("Clicked on element: {}", locator);
		} catch (StaleElementReferenceException e) {
			log.warn("Stale element detected, retrying click: {}", locator);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
	}

	public void type(WebElement element, String text) {
		try {
			WebElement el = waitForVisibility(element);
			el.clear();
			el.sendKeys(text);
		} catch (StaleElementReferenceException e) {
			log.warn("Stale element detected, retrying type");
			WebElement el = waitForVisibility(element);
			el.clear();
			el.sendKeys(text);
		}
	}

	public String getText(WebElement element) {
		return waitForVisibility(element).getText();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (TimeoutException | StaleElementReferenceException e) {
			return false;
		}
	}

	public boolean isDisplayed(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (TimeoutException | StaleElementReferenceException e) {
			return false;
		}
	}

	public String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public void type(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public void sendKeys(By locator, String value) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
	    driver.findElement(locator).sendKeys(value);
	}
	
	public void sendKeys(WebElement element, String value) {
	    element.clear();
	    element.sendKeys(value);
	}
	
	
	
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver)
		.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

	public List<WebElement> waitForElementsVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}