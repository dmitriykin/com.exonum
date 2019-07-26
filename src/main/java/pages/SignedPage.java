package pages;

import base.BaseTest;
import components.AbstractPopupPage;
import enums.ActionButton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignedPage extends AbstractPopupPage {

    @FindBy(xpath = "//input[@class='ng-pristine ng-valid']")
    protected WebElement enterEmail;

    public SignedPage(BaseTest testClass) {
        super(testClass, ActionButton.SUBMIT_BALLOT, ActionButton.DISCARD_BALLOT);
    }

    public <T extends AbstractPage> T enterAndClick(String email, Class<T> pageToReturn) {
        testClass.waitTillElementIsVisible(enterEmail).sendKeys(email);
        return clickOk(pageToReturn);
    }
}
