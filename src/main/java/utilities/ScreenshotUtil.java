package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            System.out.println("Driver is NULL - Screenshot not captured");
            return null;
        }

        try {

            File dir = new File("screenshots");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String path = "screenshots/" + testName + "_" + timeStamp + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + path);

            return path;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] attachScreenshot(WebDriver driver) {

        if (driver == null) {
            return new byte[0];
        }

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}