package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtils;

public class HomePage {

    private WebDriver driver;
    private ActionUtils utils;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.utils = new ActionUtils(driver, wait);
    }

    // Locators (NO PageFactory)
    private By welcomeUser = By.id("nameofuser");
    private By products = By.cssSelector(".hrefch");
    private By prices = By.cssSelector(".card-block h5");

    // ===== Welcome Text =====
    public String getWelcomeUserText() {

        WebElement el = driver.findElement(welcomeUser);

        return utils.getText(el);
    }

    // ===== Scroll =====
    public void scrollToProducts() {

        List<WebElement> list = driver.findElements(products);

        if (!list.isEmpty()) {
            utils.scrollIntoView(list.get(0));
        }
    }

    // ===== Product Name =====
    public String getFirstProductName() {

        List<WebElement> list = driver.findElements(products);

        return list.isEmpty() ? null : list.get(0).getText();
    }

    // ===== Product Price =====
    public String getFirstProductPrice() {

        List<WebElement> list = driver.findElements(prices);

        return list.isEmpty() ? null : list.get(0).getText();
    }
}