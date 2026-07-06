package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hooks.Hooks;
import pages.PlaceOrderPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderSteps {

    private static final Logger log = LogManager.getLogger(PlaceOrderSteps.class);

    private PlaceOrderPage pp;

    private void init() {
        if (pp == null) {
            pp = new PlaceOrderPage(Hooks.driver, Hooks.wait);
        }
    }

    @When("User clicks on Place Order button")
    public void user_clicks_on_place_order_button() {
        init();
        pp.clickPlaceOrder();
        log.info("Clicked Place Order button");
    }

    @And("User enters order details {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_order_details(String name, String country, String city,
                                         String card, String month, String year) {
        init();
        pp.fillOrderForm(name, country, city, card, month, year);
        log.info("Entered order details");
    }

    @And("User clicks on Purchase button")
    public void user_clicks_on_purchase_button() {
        init();
        pp.clickPurchase();
        log.info("Clicked Purchase button");
    }

    @Then("User accepts confirmation alert")
    public void user_accepts_confirmation_alert() {
        init();
        pp.clickOkButton();
        log.info("Accepted confirmation alert");
    }
    
    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() {
        init();
        pp.verifyConfirmationMessage();
    }
    
  
    
}