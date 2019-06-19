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
        scrollByPageElement(saveButton);
        clickOnElementByPage(saveButton);
        return this;
    }

    public MainPage clickDiscardButton() {
        scrollByPageElement(discardButton);
        clickOnElementByPage(discardButton);
        return new MainPage(testClass);
    }

    public BallotPage clickButtonDecrypt() {
        scrollByPageElement(decryptButton);
        clickOnElementByPage(decryptButton);
        return this;
    }

    public BallotPage clickOnDecryptButtonCancel() {
       decryptButtonCancel.click();
        return this;
    }

    public BallotPage clickOnDecryptButtonBallot() {
        decryptButtonBallot.click();
        return this;
    }

    public BallotPage clickSignButton() {
        scrollByPageElement(signButton);
        clickOnElementByPage(signButton);
        return this;
    }

    protected List<WebElement> findAllTable() {
        List<WebElement> table = testClass.getDriver().findElements((By) allTable);
        return table;
    }

    public void ballotPage(int i) {
        findAllTable().get(i - 1).click();
    }

    public SignedPage clickButtonSignBallot() {
        buttonSignBallot.click();
        return new SignedPage(testClass);
    }

    public BallotPage clickButtonCancel() {
        buttonCancel.click();
        return this;
    }






}
