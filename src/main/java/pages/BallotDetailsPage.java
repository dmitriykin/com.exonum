package pages;

import base.BaseTest;
import com.googlecode.junittoolbox.PollingWait;
import components.PinComponent;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BallotDetailsPage extends BasePage {

    public BallotDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickButton(Class<T> pageToReturn, ActionButton button) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        testClass.waitElementIsVisibleAndClickOfOffset(driver.findElement(By.xpath(String.format(xpath, button.getLabel()))), 766, 583);
        return createPage(pageToReturn);
    }

}
