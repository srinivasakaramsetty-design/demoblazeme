package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class AllureUtil {

	

	    @Attachment(value = "Failure Screenshot", type = "image/png")
	    public static byte[] attachScreenshot(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	}
