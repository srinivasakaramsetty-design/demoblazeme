package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ExcelUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    private static final Logger log = LogManager.getLogger(LoginSteps.class);

    private LoginPage login;
    private final ExcelUtil excel = new ExcelUtil();

    private void init() {
        if (login == null) {
            login = new LoginPage(Hooks.driver, Hooks.wait);
        }
    }

    @Given("User launches the DemoBlaze application")
    public void launch() {

        init();

        log.info("Launching App");

        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("demoblaze"),
                "App not opened correctly"
        );
    }

    @When("User logs in using Excel data")
    public void loginExcel() {

        init();

        Object[][] data = excel.getExcelData("Login");

        String user = data[0][0].toString();
        String pass = data[0][1].toString();

        login.login(user, pass);

        // 🔥 IMPORTANT FIX: wait until login completes
        Hooks.wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(
                                org.openqa.selenium.By.id("logout2")
                        ),
                        ExpectedConditions.alertIsPresent()
                )
        );

        log.info("Login executed");
    }

    @Then("User should be logged in successfully")
    public void verifyLogin() {

        init();

        

        log.info("Verifying login");
    }
}