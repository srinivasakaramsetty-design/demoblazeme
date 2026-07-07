package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import hooks.Hooks;
import io.qameta.allure.Allure;
import utilities.ScreenshotUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("===== Test Execution Started =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("===== Test Execution Finished =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Started : {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Passed : {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("Test Failed : {}", result.getName());

        // Save screenshot in screenshots folder
        ScreenshotUtil.captureScreenshot(
                Hooks.driver,
                result.getName());

        // Attach screenshot to Allure report
        ScreenshotUtil.attachScreenshot(
                Hooks.driver);

        // Attach failure reason
        if (result.getThrowable() != null) {
            Allure.addAttachment(
                    "Failure Reason",
                    result.getThrowable().toString());
        }

        log.info("Screenshot attached to Allure Report");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test Skipped : {}", result.getName());
    }
}