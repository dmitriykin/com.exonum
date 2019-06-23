package parentForTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public static final String WEB_SITE = "https://exonum.com/demo/voting/#/welcome";

    public void choiceOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        }
    }

    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public MainPage openPage() {
        driver.navigate().to(WEB_SITE);
        return new MainPage(this);
    }

    public void turnOnImplicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForLoad() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void turnOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    public void closeBrowser() {
        driver.quit();
    }
}
