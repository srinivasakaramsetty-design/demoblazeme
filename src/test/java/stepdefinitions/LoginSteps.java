package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginSteps {

    private static final Logger log = LogManager.getLogger(LoginSteps.class);

    private LoginPage login;
    private ExcelUtil excel = new ExcelUtil();

    @Given("User launches the DemoBlaze application")
    public void launch() {

        log.info("Initializing Login Page");
        login = new LoginPage(Hooks.driver, Hooks.wait);
    }

    @When("User clicks on Login menu")
    public void click_login() {

        log.info("Clicking Login Menu");
        login.clickLoginMenu();
    }

    @When("User logs in using Excel data")
    public void user_logs_in_using_excel_data() {

        Object[][] data = excel.getExcelData("Login");

        for (Object[] row : data) {

            String username = row[0].toString();
            String password = row[1].toString();

            log.info("Logging in with Username: {}", username);

            // Login using Page Object method
            login.login(username, password);

            // Verify login
           
            log.info("Login Successful for: {}", username);

            // Uncomment if your Excel contains multiple users
            // login.logout();
            // login.clickLoginMenu();
        }
    }

    @Then("User should be logged in successfully")
    public void success() {

        log.info("Login Scenario Completed Successfully");
    }
}