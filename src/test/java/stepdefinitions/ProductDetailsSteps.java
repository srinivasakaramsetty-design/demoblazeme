package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    private static final Logger log = LogManager.getLogger(ProductDetailsSteps.class);

    private ProductDetailsPage productPage;

    private void init() 
    {
        if (productPage == null)
        {
            productPage = new ProductDetailsPage(Hooks.driver, Hooks.wait);
        }
    }
    
    @Then("User should see the product details page")
    public void user_should_see_the_product_details_page()
    {

        init();

        Assert.assertTrue(productPage.isProductDetailsPageDisplayed(),
                "Product Details page is not displayed");

        log.info("Product Details page displayed successfully.");
    }

    @Then("User should verify the product name")
    public void user_should_verify_the_product_name() {

        init();

        String productName = productPage.getProductName();

        Assert.assertFalse(productName.isEmpty(), "Product name is empty");

        log.info("Product Name: {}", productName);
    }

    @Then("User should verify the product price")
    public void user_should_verify_the_product_price() {

        init();

        String productPrice = productPage.getProductPrice();

        Assert.assertFalse(productPrice.isEmpty(), "Product price is empty");

        log.info("Product Price: {}", productPrice);
    }

    @Then("User should verify the product description")
    public void user_should_verify_the_product_description() {

        init();

        String description = productPage.getProductDescription();

        Assert.assertFalse(description.isEmpty(), "Product description is empty");

        log.info("Product Description: {}", description);
    }

    
    
}