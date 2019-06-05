package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public static final String WEB_SITE = "https://exonum.com/demo/voting/#/welcome";

    public WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    // BeforeTest
    public void openPage() {
        String os = System.getProperty("os.name").toLowerCase();
        driver = new ChromeDriver();
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        }
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
