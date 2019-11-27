package pageObjectTests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSettings {
    public WebDriver driver;
    protected static final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    public String baseUrl() {
        return BASE_URL;
    }

    public void setDriver(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
    }

    @BeforeClass
    public void setup(){
       setDriver();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseUrl();
    }

    @After
    public void turnDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
