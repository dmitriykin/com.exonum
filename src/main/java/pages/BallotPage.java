package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentForPages.BasePage;
import parentForTests.BaseTest;

import java.util.List;

public class BallotPage extends BasePage {

   protected CandidatesPage candidatesPage;
   protected MainPage mainPage;

    public BallotPage(BaseTest testClass) {
        super(testClass);
    }

    @FindBy(xpath = "//div[text()='Save 3-word memo and ballot hash']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[text()='DISCARD']")
    private WebElement discardButton;
    @FindBy(xpath = "//div[text()='DECRYPT']")
    private WebElement decryptButton;
    @FindBy(xpath = "//div[text()='CANCEL']")
    private WebElement decryptButtonCancel;
    @FindBy(xpath = "//div[text()='DECRYPT BALLOT']")
    private WebElement decryptButtonBallot;
    @FindBy(xpath = "//div[text()='SIGN']")
    private WebElement signButton;
    @FindBy(xpath = "//div[@class='keyboard-button-digit']")
    private WebElement allTable;
    @FindBy(xpath = "//div[@class='keyboard-buttons']//div[text()='%s']")
    private String digitButtons;
    @FindBy(xpath = "//div[text()='SIGN BALLOT']")
    private WebElement buttonSignBallot;
    @FindBy(xpath = "//div[text()='CANCEL']")
    private WebElement buttonCancel;

    public BallotPage clickSaveButton() {
        scrollByElementAndClick(saveButton);
        return this;
    }

    public MainPage clickDiscardButton() {
       scrollByElementAndClick(discardButton);
        return new MainPage(testClass);
    }

    public BallotPage clickButtonDecrypt() {
       scrollByElementAndClick(decryptButton);
        return this;
    }

    public BallotPage clickOnDecryptButtonCancel() {
        scrollByElementAndClick(decryptButtonCancel);
        return this;
    }

    public BallotPage clickOnDecryptButtonBallot() {
        scrollByElementAndClick(decryptButtonBallot);
        return this;
    }

    public BallotPage clickSignButton() {
        scrollByElementAndClick(signButton);
        return this;
    }

//    protected List<WebElement> findAllTable() {
//        List<WebElement> table = testClass.getDriver().findElements((By) allTable);
//        return table;
//    }
//
//    public void clickButton(int digit) {
//        findAllTable().get(digit - 1).click();
//    }

    public SignedPage clickButtonSignBallot() {
        scrollByElementAndClick(buttonSignBallot);
        return new SignedPage(testClass);
    }

    public BallotPage clickButtonCancel() {
        scrollByElementAndClick(buttonCancel);
        return this;
    }






}
