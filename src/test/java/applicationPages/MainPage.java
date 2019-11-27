package applicationPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//body[@id='mn_h']") //for Alaska
    private WebElement pageLoaded;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkURL() {
        return driver.getCurrentUrl();
    }

    public boolean verifyMainPageIsLoaded(){
        try {
            if (pageLoaded.isDisplayed()){
                System.out.println("The main page is loaded!!!");
                return pageLoaded.isEnabled();
            } else return false;
        } catch (NoSuchElementException e) {
            System.out.println("The main page is not loaded!!!");
            return false;
        }
    }
}
