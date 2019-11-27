package pageObjectTests;

import applicationPages.LoginPage;
import applicationPages.MainPage;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RozetkaTest extends TestSettings {
    LoginPage loginPage;
    MainPage mainPage;

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        loginPage.clickOnLogin();
        loginPage.enterNumber("7W05VC2");
        loginPage.enterPassword("Pa55word");
        loginPage.clickLoginButton();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsLoaded());
        assertTrue(mainPage.checkURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Test
    public void loginIsNegative(){
        loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        loginPage.enterNumber("7W05VC2");
        loginPage.enterPassword("Pa55word1");
        loginPage.clickLoginButton();
        mainPage = new MainPage(driver);
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsLoaded());
        assertFalse(mainPage.checkURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}