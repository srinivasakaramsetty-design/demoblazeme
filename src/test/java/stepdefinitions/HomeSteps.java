package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomeSteps {

    private static final Logger log = LogManager.getLogger(HomeSteps.class);

    HomePage home;

    public HomeSteps() {
        home = new HomePage(Hooks.driver);
    }

    @Then("User should see welcome message with username")
    public void user_should_see_welcome_message_with_username() {

        log.info("Verifying Welcome Username");

        String welcomeText = home.getWelcomeUserText();

        log.info("Welcome Text: {}", welcomeText);

        Assert.assertTrue(
                welcomeText.startsWith("Welcome"),
                "Welcome username is not displayed.");

        log.info("Welcome Username Verified Successfully");
    }

    @Then("User should see product list displayed")
    public void user_should_see_product_list_displayed() {

        log.info("Verifying Product Details");

        home.scrollToProducts();

        String productName = home.getFirstProductName();
        String productPrice = home.getFirstProductPrice();

        log.info("Product Name : {}", productName);
        log.info("Product Price : {}", productPrice);

        Assert.assertFalse(
                productName.isEmpty(),
                "Product Name is empty");

        Assert.assertTrue(
                productPrice.startsWith("$"),
                "Product Price is not displayed correctly");

        log.info("Home Page Verified Successfully");
    }
}