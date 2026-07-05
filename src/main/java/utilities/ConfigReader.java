package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties pro;

    public ConfigReader() {

        pro = new Properties();

        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException("config.properties not found in resources folder");
            }

            pro.load(is);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBrowser() {
        return pro.getProperty("browser", "chrome");
    }

    public String getUrl() {
        return pro.getProperty("url");
    }

    public int getExplicitWait() {
        return Integer.parseInt(pro.getProperty("explicitWait", "10"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(pro.getProperty("pageLoadTimeout", "20"));
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(pro.getProperty("headless", "false"));
    }
}