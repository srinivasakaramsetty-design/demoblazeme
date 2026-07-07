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
import pages.PlaceOrderPage;

public class PlaceOrderSteps {

    private static final Logger log = LogManager.getLogger(PlaceOrderSteps.class);

    private PlaceOrderPage pp;

    private void init() {
        if (pp == null) {
            pp = new PlaceOrderPage(Hooks.driver, Hooks.wait);
        }
    }

    @When("User clicks on Place Order button")
    @Description("Verify user can click Place Order button")
    @Severity(SeverityLevel.CRITICAL)
    public void user_clicks_on_place_order_button() throws InterruptedException {

        init();

        Allure.step("Click Place Order button");

        pp.clickPlaceOrder();
        Thread.sleep(5000);

        log.info("Clicked Place Order button");
    }

    @And("User enters order details {string}, {string}, {string}, {string}, {string}, {string}")
    @Description("Verify user enters valid order details")
    @Severity(SeverityLevel.CRITICAL)
    public void user_enters_order_details(String name,
                                          String country,
                                          String city,
                                          String card,
                                          String month,
                                          String year) {

        init();

        Allure.step("Enter customer details");
        Allure.step("Name: " + name);
        Allure.step("Country: " + country);
        Allure.step("City: " + city);

        pp.fillOrderForm(name, country, city, card, month, year);

        log.info("Entered order details");
    }

    @And("User clicks on Purchase button")
    @Description("Verify user can place order successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void user_clicks_on_purchase_button() {

        init();

        Allure.step("Click Purchase button");

        pp.clickPurchase();

        log.info("Clicked Purchase button");
    }

    @Then("User should see order confirmation message")
    @Description("Verify order confirmation message is displayed")
    @Severity(SeverityLevel.BLOCKER)
    public void user_clicks_ok_button() {

        init();

        Allure.step("Verify confirmation message");

        pp.verifyConfirmationMessage();
    }

    @Then("User accepts confirmation alert")
    @Description("Verify user accepts order confirmation popup")
    @Severity(SeverityLevel.NORMAL)
    public void user_should_see_order_confirmation_message() {

        init();

        Allure.step("Click OK button on confirmation popup");

        pp.clickOkButton();

        log.info("Order confirmation message verified successfully");
    }
}