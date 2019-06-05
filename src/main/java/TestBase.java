import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private WebDriver driver = new ChromeDriver();

    public WebDriver getDriver() {
        return driver;
    }

     public static final String WEB_SITE = "https://exonum.com/demo/voting/#/welcome";


    // BeforeTest
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\driversForBrowsers\\chromedriver.exe");
        driver.navigate().to(WEB_SITE);
    }

    public void openBrowser() {
        turnOnImplicitWait();
        driver.manage().window().maximize();
    }

    public void turnOnImplicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void turnOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    // AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
