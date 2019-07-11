package pages;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BallotDetailsPage extends BasePage {
    public BallotDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickButton(Class<T> pageToReturn, ActionButton button) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        testClass.waitTillClickableAndClickElement(driver.findElement(By.xpath(String.format(xpath, button.getLabel()))));
        return createPage(pageToReturn);
    }
}
