package pages;

import base.BaseTest;
import com.googlecode.junittoolbox.PollingWait;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BallotDetailsPage extends BasePage {

    public BallotDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickButton(Class<T> pageToReturn, ActionButton button) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        new PollingWait()
                .pollEvery(2, TimeUnit.SECONDS)
                .timeoutAfter(30, TimeUnit.SECONDS);
        testClass.scrollToElementByJsAndClick(driver.findElement(By.xpath(String.format(xpath, button.getLabel()))));
        return createPage(pageToReturn);
    }
}
