package dataprovider;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtil;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        ExcelUtil excel = new ExcelUtil();
        return excel.getExcelData("Login");
    }
}