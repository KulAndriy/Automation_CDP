package JBehaveTests;


import applicationPages.LoginPage;
import applicationPages.MainPage;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectTests.TestSettings;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class JBehaveTestSteps {
    public WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    public TestSettings testSettings;

    @BeforeScenario
    public void before() {
        testSettings = new TestSettings();
        testSettings.setDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterScenario
    public void after() {
        driver.quit();
    }

    private void baseUrl(){
        driver.get(testSettings.baseUrl());
    }

    @Given("that American Airlines site \"$keyword\" is opened")
    public void getMainPage() {
        baseUrl();
    }

    @When("user click on login button and user enter account number \"$keyword\" and user enter password \"$keyword\"")
    public void login(String login, String password) {
        loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        loginPage.enterNumber(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("user is logged in and user go to the main page.")
    public void validatePositiveResult() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsLoaded());
        assertTrue(mainPage.checkURL().equals(testSettings.baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Then("user is not logged in and user get error message.")
    public void validateNegativeResult() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsLoaded());
        assertFalse(mainPage.checkURL().equals(testSettings.baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }



}
