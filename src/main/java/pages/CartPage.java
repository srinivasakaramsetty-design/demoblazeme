package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtils;

public class CartPage {

	private ActionUtils utils;
	private WebDriver driver;

	// Locators
	private By addToCartButton = By.linkText("Add to cart");
	private By cartButton = By.id("cartur");
	private By cartItems = By.xpath("//tr/td[2]");





	// Correct constructor
	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.utils = new ActionUtils(driver, wait);
	}

	// Click Add to Cart button
	public void clickAddToCart() {
		utils.waitForElementClickable(addToCartButton);
		utils.click(addToCartButton);
	}


	// Accept alert
	public void acceptAlert() {
		utils.acceptAlert();
	}

	// Click cart
	public void clickCart() {
		utils.waitForElementClickable(cartButton);
		utils.click(cartButton);
	}

	// Verify product in cart
	public boolean isProductPresentInCart(String productName) {

		List<WebElement> products = utils.waitForElementsVisible(cartItems);

		for (WebElement product : products) {
			if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
				return true;
			}
		}
		return false;
	}
}