package applicationPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.aadvantageeshopping.com/j____.htm']")
    private WebElement logIn;
    @FindBy(xpath = "//input[@type='text'][@id='mn_lookupId']")
    private WebElement number;
    @FindBy(xpath = "//input[@type='password'][@id='mn_password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//input[@class='mn_button'][@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='mn_errorListWrap'][@role='alert']")
    private WebElement errorAlert;
    @FindBy(xpath = "//nav[@class='mn_accountNav mn_accountLoggedIn']")
    private WebElement userLoggedIn;

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogin(){
        logIn.click();
        System.out.println("Clicks on Login link");
    }

    public void enterNumber(String email) {
        this.number.clear();
        this.number.sendKeys(email);
        System.out.println("Email is entered");
    }

    public void enterPassword(String password) {
        this.enterPassword.clear();
        this.enterPassword.sendKeys(password);
        System.out.println("Password is entered");
    }

    public void clickLoginButton() {
        loginButton.click();
        System.out.println("Login button is clicked");
    }

    public boolean userIsLoggedIn(){
        try {
            if (userLoggedIn.isDisplayed()) {
                System.out.println("Login is success!!!");
                return userLoggedIn.isDisplayed();
            }else return false;
        } catch (NoSuchElementException e) {
            System.out.println("Login is not success!!!");
            return false;
        }
    }

    public boolean wrongLogin(){
        try {
            if (errorAlert.isDisplayed()){
                System.out.println("Errors while login, please verify your credentials!!!");
                return errorAlert.isDisplayed();
            } else return false;
        } catch (NoSuchElementException e) {
            System.out.println("No errors while login!!!!");
            return false;
        }
    }
}
