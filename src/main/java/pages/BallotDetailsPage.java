package pages;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BallotDetailsPage extends BasePage {
    public BallotDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    private WebElement button;


    public void clickableByButton(ActionButton button) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        if (this.button != null)
            this.button = driver.findElement(By.xpath(String.format(xpath, button.getLabel())));
    }


    public <T extends AbstractPage> T clickOk(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, this.button);
    }

    private <T extends AbstractPage> T clickButtonAndReturnPage(Class<T> pageToReturn, WebElement button) {
        testClass.waitTillClickableAndClickElement(button);
        return createPage(pageToReturn);
    }


}
