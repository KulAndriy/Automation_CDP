package cucumberTests;

import applicationPages.LoginPage;
import applicationPages.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectTests.TestSettings;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CucumberTestSteps {
    public WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    public TestSettings testSettings;

    @Before
    public void before() {
        testSettings = new TestSettings();
        testSettings.setDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.quit();
    }

    public void baseUrl (){
        driver.get(testSettings.baseUrl());
    }

    @Given("^that American Airlines site is opened$")
        public void getMainPage () {
        baseUrl();
    }

    @When("^user click on login button and user enter account number \"([^\"]*)\" and user enter password \"([^\"]*)\"$")
        public void login(String login, String password) {
        loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        loginPage.enterNumber(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("^user is logged in and user go to the main page.$")
    public void validatePositiveResult() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsLoaded());
        assertTrue(mainPage.checkURL().equals(testSettings.baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Then("^user is not logged in and user get error message.$")
    public void validateNegativeResult() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsLoaded());
        assertFalse(mainPage.checkURL().equals(testSettings.baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}
