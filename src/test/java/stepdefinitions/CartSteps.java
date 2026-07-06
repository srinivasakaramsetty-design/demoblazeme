package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ProductDetailsPage;

public class CartSteps 
{

	private static final Logger log = LogManager.getLogger(CartSteps.class);

	private CartPage cp;

	private void init() 
	{
		if (cp == null)
		{
			cp = new CartPage(Hooks.driver, Hooks.wait);
		}
	}


	@When("User clicks on {string} button")
	public void user_clicks_on_button(String buttonName) 
	{
		init();  
		cp.clickAddToCart();
		log.info("Clicked on Add to Cart button.");
	}

	@And("User accepts the alert")
	public void user_accepts_the_alert() 
	{
		 init();   
		cp.acceptAlert();
		log.info("Alert accepted successfully.");
	}

	@Then("User should see the product added to cart successfully")
	public void user_should_see_the_product_added_to_cart_successfully() 
	{
		 init();   
		cp.clickCart();
		log.info("Product added to cart successfully.");
	}
}
