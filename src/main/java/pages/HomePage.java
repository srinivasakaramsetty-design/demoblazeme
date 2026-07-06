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
    private WebDriverWait wait;


    public HomePage(WebDriver driver, WebDriverWait wait)
    {
    	this.driver = driver;   // <-- Don't forget this
        this.wait = wait;
        this.utils = new ActionUtils(driver, wait);
    }

    // Locators
    private By welcomeUser = By.id("nameofuser");
    private By products = By.cssSelector(".hrefch");
    private By prices = By.cssSelector(".card-block h5");

    // Welcome Message
    public String getWelcomeUserText() {
        return utils.getText(driver.findElement(welcomeUser));
    }

    // Scroll to Products
    public void scrollToProducts() {
        List<WebElement> list = driver.findElements(products);
        if (!list.isEmpty()) {
            utils.scrollIntoView(list.get(0));
        }
    }

    // Click Any Product
    public void clickProduct(String productName) 
    {
        By product = By.xpath("//a[text()='" + productName + "']");
        utils.click(product);
    }

    // First Product Name
    public String getFirstProductName() {
        List<WebElement> list = driver.findElements(products);
        return list.isEmpty() ? null : list.get(0).getText();
    }

    // First Product Price
    public String getFirstProductPrice() {
        List<WebElement> list = driver.findElements(prices);
        return list.isEmpty() ? null : list.get(0).getText();
    }
}