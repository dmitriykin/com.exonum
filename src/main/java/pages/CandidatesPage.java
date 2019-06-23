package pages;

import allTable.AllTablePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentForTests.BaseTest;

public class CandidatesPage extends AllTablePage {

   protected ElectionsPage electionsPage;

    @FindBy(xpath = "//div[@class='toolbar-return-button pull-left']")
    private WebElement buttonReturn;
    @FindBy(xpath = "//div[text()='HELP']")
    private WebElement helpButton;
    @FindBy(xpath = "//table[@class='app-list']")
    private WebElement tableCandidatesPage;
    @FindBy(xpath = "//a[text()='Official candidate page']")
    private WebElement officialCandidatesPage;
    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoiteOnCandidatesPage;
    @FindBy(xpath = "//div[text()='CANCEL']")
    private WebElement closeButton;
    @FindBy(xpath = "//div[text()='YES']")
    private WebElement buttonYes;

    public CandidatesPage(BaseTest testClass) {
        super(testClass);
    }

    public ElectionsPage returnOnElectionsPage() {
        scrollByElementAndClick(buttonReturn);
        return new ElectionsPage(testClass);
    }

    public CandidatesPage clickButtonHelpOnCandidatesPage() {
        scrollByElementAndClick(helpButton);
        return this;
    }

    public CandidatesPage choiceCandidates(int numberCandidates) {
        rows(tableCandidatesPage);
        checkElements(numberCandidates);
        return this;
    }

    public CandidatesPage clickButtonOnCandidatesPage() {
        scrollByElementAndClick(buttonVoiteOnCandidatesPage);
        return this;
    }

    public CandidatesPage closeAboutPage() {
        scrollByElementAndClick(closeButton);
        return this;
    }

    public BallotPage openBalletPage() {
        scrollByElementAndClick(buttonYes);
        return new BallotPage(testClass);
    }



}
