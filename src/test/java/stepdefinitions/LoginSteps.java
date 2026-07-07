package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Description("Verify DemoBlaze application launches successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void launch() {

        init();

        Allure.step("Launch DemoBlaze application");

        log.info("Launching App");

        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("demoblaze"),
                "App not opened correctly"
        );
    }

    @When("User logs in using Excel data")
    @Description("Verify user can login using credentials from Excel")
    @Severity(SeverityLevel.CRITICAL)
    public void loginExcel() {

        init();

        Object[][] data = excel.getExcelData("Login");

        String user = data[0][0].toString();
        String pass = data[0][1].toString();

        Allure.step("Read username and password from Excel");

        login.login(user, pass);

        Allure.step("Login with username: " + user);

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
    @Description("Verify successful login to application")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyLogin() {

        init();

        Allure.step("Verify Logout button is displayed");

        Assert.assertTrue(
                Hooks.driver.findElement(
                        org.openqa.selenium.By.id("logout2"))
                        .isDisplayed(),
                "Login failed"
        );

        log.info("Verifying login");
    }
}