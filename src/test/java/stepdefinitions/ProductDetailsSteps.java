package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    private static final Logger log = LogManager.getLogger(ProductDetailsSteps.class);

    private ProductDetailsPage productPage;

    private void init() {
        if (productPage == null) {
            productPage = new ProductDetailsPage(Hooks.driver, Hooks.wait);
        }
    }

    @Then("User should see the product details page")
    @Description("Verify Product Details page is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void user_should_see_the_product_details_page() {

        init();

        Allure.step("Verify Product Details page is displayed");

        Assert.assertTrue(
                productPage.isProductDetailsPageDisplayed(),
                "Product Details page is not displayed");

        log.info("Product Details page displayed successfully.");
    }

    @Then("User should verify the product name")
    @Description("Verify Product Name is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void user_should_verify_the_product_name() {

        init();

        String productName = productPage.getProductName();

        Allure.step("Product Name: " + productName);

        Assert.assertFalse(
                productName.isEmpty(),
                "Product name is empty");

        log.info("Product Name: {}", productName);
    }

    @Then("User should verify the product price")
    @Description("Verify Product Price is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void user_should_verify_the_product_price() {

        init();

        String productPrice = productPage.getProductPrice();

        Allure.step("Product Price: " + productPrice);

        Assert.assertFalse(
                productPrice.isEmpty(),
                "Product price is empty");

        log.info("Product Price: {}", productPrice);
    }

    @Then("User should verify the product description")
    @Description("Verify Product Description is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void user_should_verify_the_product_description() {

        init();

        String description = productPage.getProductDescription();

        Allure.step("Product Description: " + description);

        Assert.assertFalse(
                description.isEmpty(),
                "Product description is empty");

        log.info("Product Description: {}", description);
    }
}