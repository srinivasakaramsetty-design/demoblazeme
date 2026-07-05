package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import hooks.Hooks;

public class ScreenshotUtil
{

    public static String captureScreenshot(String testName) 
    {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = "screenshots/" + testName + "_" + timeStamp + ".png";

        File src = ((TakesScreenshot) Hooks.driver).getScreenshotAs(OutputType.FILE);

        try 
        {
            FileUtils.copyFile(src, new File(path));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return path;
    }
}