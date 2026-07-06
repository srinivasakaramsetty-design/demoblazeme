package hooks;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    public static WebDriver driver;
    public static WebDriverWait wait;

    ConfigReader config = new ConfigReader();

    @Before
    public void setUp() {

        log.info("==================================");
        log.info("Starting Test Execution");
        log.info("Launching Chrome Browser");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(config.getPageLoadTimeout()));

        driver.get(config.getUrl());

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(config.getExplicitWait()));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            log.error("Scenario Failed: Taking Screenshot");

            if (driver != null) {
                ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            }
        }

        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }

        log.info("Test Execution Completed");
    }
}