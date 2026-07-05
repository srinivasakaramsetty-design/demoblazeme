package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login2")
	private WebElement loginMenu;

	@FindBy(id = "loginusername")
	private WebElement username;

	@FindBy(id = "loginpassword")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	@FindBy(id = "logout2")
	private WebElement logoutLink;

	// 1. Click Login menu
	public void clickLoginMenu() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginMenu));
		loginMenu.click();
	}

	// 2. Enter username
	public void enterUsername(String user) {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.clear();
		username.sendKeys(user);
	}

	// 3. Enter password
	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(pass);
	}

	// 4. Click login button
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}

	// 5. Full flow
	public void login(String user, String pass) 
	{
		enterUsername(user);
		enterPassword(pass);
		clickLoginButton();
		
	}

	

	public void logout() 
	{
	    wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
	    logoutLink.click();
	}
	
	
	
	public boolean isLogoutDisplayed() {
	    wait.until(ExpectedConditions.visibilityOf(logoutLink));
	    return logoutLink.isDisplayed();
	}


}