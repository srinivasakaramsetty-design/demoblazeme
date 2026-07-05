package pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger log = LogManager.getLogger(HomePage.class);

    // Locators
    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;

    @FindBy(css = ".hrefch")
    private List<WebElement> products;

    @FindBy(xpath = "//h5[contains(text(),'$')]")
    private List<WebElement> productPrices;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

        // 🔥 Explicit Wait = 15 seconds (as requested)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    // =========================
    // Common Wait Method
    // =========================
    private void waitForElement(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // =========================
    // Welcome Username
    // =========================
    public String getWelcomeUserText() {

        waitForElement(welcomeUser);

        String text = welcomeUser.getText();
        log.info("Welcome User: {}", text);

        return text;
    }

    // =========================
    // Scroll to Products
    // =========================
    public void scrollToProducts() {

        if (products.size() > 0) 
        {
            wait.until(ExpectedConditions.visibilityOf(products.get(0)));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", products.get(0));

            log.info("Scrolled to first product");
        }
    }

    // =========================
    // Get First Product Name
    // =========================
    public String getFirstProductName() {

        wait.until(ExpectedConditions.visibilityOfAllElements(products));

        String name = products.get(0).getText();
        log.info("First Product Name: " + name);

        return name;
    }

    // =========================
    // Get First Product Price
    // =========================
    public String getFirstProductPrice() {

        wait.until(ExpectedConditions.visibilityOfAllElements(productPrices));

        String price = productPrices.get(0).getText();
        log.info("First Product Price: " + price);

        return price;
    }
}