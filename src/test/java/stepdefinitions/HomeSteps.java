package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;

public class HomeSteps {

    private static final Logger log = LogManager.getLogger(HomeSteps.class);

    private HomePage home;

    private void init() {
        if (home == null) {
            home = new HomePage(Hooks.driver, Hooks.wait);
        }
    }

    @Then("User should see welcome message with username")
    @Description("Verify welcome message is displayed after successful login")
    @Severity(SeverityLevel.CRITICAL)
    public void user_should_see_welcome_message_with_username() {

        init();

        String text = home.getWelcomeUserText();

        Allure.step("Verify welcome message: " + text);

        log.info("Welcome text: {}", text);

        Assert.assertTrue(text.contains("Welcome"));
    }

    @Then("User should see product list displayed")
    @Description("Verify product list is displayed on home page")
    @Severity(SeverityLevel.NORMAL)
    public void user_should_see_product_list_displayed() {

        init();

        Allure.step("Verify product list is displayed");

        Assert.assertTrue(
                home.getFirstProductName() != null,
                "Product list is not displayed");
    }

    @And("User clicks on {string} product")
    @Description("Verify user can select a product from home page")
    @Severity(SeverityLevel.CRITICAL)
    public void user_clicks_on_product(String productName) {

        init();

        Allure.step("Clicking on product: " + productName);

        home.clickProduct(productName);

        log.info("Clicked on Product: {}", productName);
    }
}