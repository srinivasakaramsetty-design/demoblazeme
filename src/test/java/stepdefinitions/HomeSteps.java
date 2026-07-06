package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
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
    public void user_should_see_welcome_message_with_username() {

        init();

        String text = home.getWelcomeUserText();
        log.info("Welcome text: " + text);

        Assert.assertTrue(text.contains("Welcome"));
    }

    @Then("User should see product list displayed")
    public void user_should_see_product_list_displayed() {

        init();

        Assert.assertTrue(home.getFirstProductName() != null, "Product list is not displayed");
    }
}