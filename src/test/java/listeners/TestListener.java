package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        log.error("Reason : ", result.getThrowable());

        String screenshot = ScreenshotUtil.captureScreenshot(result.getName());

        log.info("Screenshot saved at : {}", screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test Skipped : {}", result.getName());
    }
}