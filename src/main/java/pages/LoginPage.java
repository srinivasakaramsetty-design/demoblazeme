package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtils;

public class LoginPage {

    private ActionUtils utils;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
        utils = new ActionUtils(driver, wait);
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

    public void login(String user, String pass) {

        utils.click(loginMenu);

        utils.type(username, user);
        utils.type(password, pass);

        utils.click(loginButton);

        // IMPORTANT FIX: wait until logout appears
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
    }

    public boolean isLogoutDisplayed() {
        return logoutLink.isDisplayed();
    }
}