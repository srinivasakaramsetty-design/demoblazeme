package utilities;

import io.qameta.allure.Allure;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AllureLogoUtil {
	 public static void attachLogo() {
	        try {
	            Allure.addAttachment(
	                    "Company Logo",
	                    "image/png",
	                    new FileInputStream("src/test/resources/logo.png"),
	                    ".png");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
