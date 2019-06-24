package base;

import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.reporters.SuiteHTMLReporter;
import org.testng.reporters.XMLReporter;
import pages.MainPage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static constants.WaitConstant.EXPLICIT_WAIT;

@Log
@Listeners({SuiteHTMLReporter.class, XMLReporter.class})
public abstract class BaseTest {

    private static WebDriver driver;
    private static Actions actions = null;
    private static Wait wait = null;

    public WebDriver getDriver() {
        return driver;
    }

    public static final String WEB_SITE = "https://exonum.com/demo/voting/#/welcome";

    @BeforeTest
    protected void setUp() {
        configureDriver();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        turnOnImplicitWait();
        actions = new Actions(driver);
    }

    @AfterMethod
    protected void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) snapScreenshot();
    }

    @AfterTest
    protected void tearDown() {
        driver.quit();
    }

    private void configureDriver() {
        setDriverPathByOs();
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("disable-infobars", "--disable-extensions", "test-type");
        chromeOptions.setCapability("pageLoadStrategy", "none");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1440, 900));
    }

    private void setDriverPathByOs() {
        String osDriverName;
        String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if ((os.contains("mac")) || (os.contains("darwin"))) {
            osDriverName = "mac64";
        } else if (os.contains("win")) {
            osDriverName = "win_32.exe";
        } else if (os.contains("nux")) {
            osDriverName = "linux64"; //TODO: add chrome_linux64 driver into resources
        } else {
            throw new RuntimeException("Cannot define your OS: " + os);
        }
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome_" + osDriverName);
    }

    private void snapScreenshot() {
        DateFormat date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        String fileName = this.getClass().getName() + "_" + date.format(new Date());
        String screenshotPath = System.getProperties().get("user.dir") + "\\screenshots\\";
        try {
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File(screenshotPath + File.separator + fileName + ".png"));
            log.config("Screenshot file [" + fileName + "]" + " written in [" + screenshotPath + "]");
        } catch (IOException e) {
            throw new RuntimeException("Unable to store screenshot.", e);
        }
    }

    protected MainPage openWebApp() {
        driver.get(WEB_SITE);
        return new MainPage(this);
    }

    private void turnOnImplicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void turnOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    public WebElement scrollToElementByJs(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void scrollToElementByJsAndClick(WebElement element) {
        scrollToElementByJs(element);
        element.click();
    }

    public void waitTillClickableAndClickElement(WebElement element) {
        waitTillElementIsClickable(element);
        element.click();
    }

    public void waitTillElementIsVisible(WebElement element) {
        waitTillElementIsVisible(element, false, EXPLICIT_WAIT);
    }

    public void waitTillElementIsVisible(WebElement element, boolean throwException, long timeOutInSeconds) {
        try {
            turnOffImplicitWait();
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            if (throwException) {
                throw (e);
            }
            Assert.fail("NoSuchElement exception caught for element " + e.toString());
        } catch (TimeoutException e) {
            if (throwException) {
                throw (e);
            }
            Assert.fail("Timeout exception caught for element " + e.toString());
        } finally {
            turnOnImplicitWait();
        }
    }

    public void waitTillElementsAreVisible(List<WebElement> elements) {
        waitTillElementsAreVisible(elements, false, EXPLICIT_WAIT);
    }

    public void waitTillElementsAreVisible(List<WebElement> elements, boolean throwException, long timeOutInSeconds) {
        try {
            turnOffImplicitWait();
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (NoSuchElementException e) {
            if (throwException) {
                throw (e);
            }
            Assert.fail("NoSuchElement exception caught for element " + e.toString());
        } catch (TimeoutException e) {
            if (throwException) {
                throw (e);
            }
            Assert.fail("Timeout exception caught for element " + e.toString());
        } finally {
            turnOnImplicitWait();
        }
    }

    public void waitTillElementIsClickable(WebElement element) {
        try {
            turnOffImplicitWait();
            WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT);
            wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            Assert.fail("NoSuchElement exception caught for element " + e.toString());
        } catch (TimeoutException e) {
            Assert.fail("Timeout exception caught for element " + e.toString());
        } finally {
            turnOnImplicitWait();
        }
        actions.moveToElement(element).build().perform();
    }

}