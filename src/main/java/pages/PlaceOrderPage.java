package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtils;

public class PlaceOrderPage 
{

	private WebDriver driver;
	private ActionUtils utils;
	private WebDriverWait wait;

	private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	private By name = By.id("name");
	private By country = By.id("country");
	private By city = By.id("city");
	private By card = By.id("card");
	private By month = By.id("month");
	private By year = By.id("year");
	private By purchaseBtn = By.xpath("//button[text()='Purchase']");
	private By closeBtn = By.xpath("//button[text()='Close']");
	private By confirmationMsg = By.xpath("//h2[contains(text(),'Thank you')]");
	private By okButton = By.xpath("//button[text()='OK']");
	



	public PlaceOrderPage(WebDriver driver, WebDriverWait wait) 
	{
		this.wait = wait;
		this.driver = driver;
		this.utils = new ActionUtils(driver, wait);
	}

	public void clickPlaceOrder() 
	{

		utils.click(placeOrderBtn);
	}

	public void fillOrderForm(String nameValue, String countryValue, String cityValue,
			String cardValue, String monthValue, String yearValue) 
	{

		utils.type(name, nameValue);
		utils.type(country, countryValue);
		utils.type(city, cityValue);
		utils.type(card, cardValue);
		utils.type(month, monthValue);
		utils.type(year, yearValue);
	}
	
	public void clickPurchase() 
	{
		utils.click(purchaseBtn);
	}
	
	public String getConfirmationMessage() 
	{
		return utils.getText(confirmationMsg);
	}
	
	public void clickOkButton() 
	{
	    utils.click(okButton);
	    
	}
	
	public void closeConfirmationDialog() 
	{
	    utils.click(closeBtn);
	}
	

	public void verifyConfirmationMessage() {
	    String message = utils.getText(confirmationMsg);

	    if (message == null || !message.toLowerCase().contains("thank you")) {
	        throw new AssertionError("Order confirmation message not displayed correctly. Actual: " + message);
	    }
	}
	
	

}
