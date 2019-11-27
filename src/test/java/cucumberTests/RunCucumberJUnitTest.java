package cucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(format= {"pretty"},features="src/test/resources/cucumberTests/login.feature")

public class RunCucumberJUnitTest { }

