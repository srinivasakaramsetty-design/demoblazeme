package utilities;

import java.time.Duration;
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

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        try {
            waitForClickable(element).click();
        } catch (StaleElementReferenceException e) {
            log.warn("Stale element detected, retrying click");
            waitForClickable(element).click();
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

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}