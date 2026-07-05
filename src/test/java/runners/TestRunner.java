package runners;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(listeners.TestListener.class)
@CucumberOptions(

        features = 
                "src/test/resources/features/LoginAndHome.feature",
         glue = {"stepdefinitions", "hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests 
{
	
}