import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public WebDriver driver;
    private String webSite = "https://exonum.com/demo/voting/#/elections/candidates";

    public String getWebSite() {
        return webSite;
    }

    // BeforeTest
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\driversForBrowsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(getWebSite());
        turnOnImplicitWait();
        driver.manage().window().maximize();
    }

    public void turnOnImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void turnOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    // AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
