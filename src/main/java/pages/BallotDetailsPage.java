package pages;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BallotDetailsPage extends BasePage {

    @FindBy(xpath = "//div[.='Ballot reciept 3-word memo']")
    private WebElement fieldBallotReceipt;

    @FindBy(xpath = "//div[.='Ballot  SHA256 hash']")
    private WebElement fieldBallotSHA256;


    public BallotDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickButton(Class<T> pageToReturn, ActionButton button) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        WebElement buttonElement =
                testClass.waitTillElementIsClickable(driver.findElement(By.xpath(String.format(xpath, button.getLabel()))));
        testClass.scrollToElementByJsAndClick(buttonElement);
        return createPage(pageToReturn);
    }

}
