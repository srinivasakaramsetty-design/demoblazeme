package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionUtils;

public class ProductDetailsPage {

    private ActionUtils utils;
    private WebDriver driver;

    // Locators
    private By productName = By.cssSelector("h2.name");
    private By productPrice = By.cssSelector("h3.price-container");
    private By productDescription = By.cssSelector("#more-information p");

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.utils = new ActionUtils(driver, wait);
    }

    public boolean isProductDetailsPageDisplayed() {
        return utils.isDisplayed(productName);
    }

    public String getProductName() {
        return utils.getText(productName);
    }

    public String getProductPrice() {
        return utils.getText(productPrice);
    }

    public String getProductDescription() {
        return utils.getText(productDescription);
    }
}