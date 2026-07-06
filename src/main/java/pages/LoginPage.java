package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtils;

public class LoginPage {

    private WebDriver driver;
    private ActionUtils utils;
    private WebDriverWait wait;

    // Locators
    private By loginMenu = By.id("login2");
    private By username = By.id("loginusername");
    private By password = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
 

    public LoginPage(WebDriver driver, WebDriverWait wait) {
    	this.driver = driver;   // <-- Don't forget this
        this.wait = wait;
  
        this.utils = new ActionUtils(driver, wait);
    }

    public void login(String user, String pass) {

        utils.click(driver.findElement(loginMenu));

        utils.type(driver.findElement(username), user);

        utils.type(driver.findElement(password), pass);

        utils.click(driver.findElement(loginButton));

        
    }

    
}