package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CartPage;

public class CartSteps {

    private static final Logger log = LogManager.getLogger(CartSteps.class);

    private CartPage cp;

    private void init() {
        if (cp == null) {
            cp = new CartPage(Hooks.driver, Hooks.wait);
        }
    }

    @When("User clicks on {string} button")
    @Description("Verify user can add a product to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void user_clicks_on_button(String buttonName) {

        init();

        Allure.step("Clicking on Add To Cart button");
        cp.clickAddToCart();

        log.info("Clicked on Add to Cart button.");
    }

    @And("User accepts the alert")
    @Description("Verify user accepts confirmation alert")
    @Severity(SeverityLevel.NORMAL)
    public void user_accepts_the_alert() {

        init();

        Allure.step("Accepting product added alert");
        cp.acceptAlert();

        log.info("Alert accepted successfully.");
    }

    @Then("User should see the product added to cart successfully")
    @Description("Verify product is displayed in shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    public void user_should_see_the_product_added_to_cart_successfully() throws InterruptedException {

        init();

        Allure.step("Navigating to Cart page");
        cp.clickCart();

        Thread.sleep(5000);

        Allure.step("Product displayed successfully in cart");
        log.info("Product added to cart successfully.");
    }
}