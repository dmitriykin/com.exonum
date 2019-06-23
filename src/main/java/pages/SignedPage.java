package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentForPages.BasePage;
import parentForTests.BaseTest;

public class SignedPage extends BasePage {

    protected MainPage mainPage;

    public SignedPage(BaseTest testClass) {
        super(testClass);
    }

    @FindBy(xpath = "//input[@placeholder='Your mail']")
    private WebElement enterYourEmail;
    @FindBy(xpath = "//div[text()='SUBMIT BALLOT']")
    private WebElement buttonSubmitBallot;
    @FindBy(xpath = "//div[text()='DISCARD BALLOT']")
    private WebElement buttonDiscardBallot;

    public SignedPage email(String yourEmail) {
        enterYourEmail.sendKeys(yourEmail);
        return this;
    }

    public SignedPage clickSubmit() {
        scrollByElementAndClick(buttonDiscardBallot);
        return this;
    }

    public MainPage clickDiscard() {
        scrollByElementAndClick(buttonDiscardBallot);
        return new MainPage(testClass);
    }


}
