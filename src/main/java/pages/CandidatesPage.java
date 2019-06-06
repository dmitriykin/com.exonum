package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentForPages.BasePage;
import parentForTests.BaseTest;

import java.util.List;

public class CandidatesPage extends BasePage {

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
        buttonReturn.click();
        return new ElectionsPage(testClass);
    }

    public CandidatesPage clickButtonHelpOnCandidatesPage() {
        helpButton.click();
        return this;
    }
    public List<WebElement> rowsOnCandidatesPage() {
        return electionsPage.rows();
    }

    public CandidatesPage checkCandidates(int candidates) {
        electionsPage.checkElements(candidates);
        return this;
    }

    public WikipediaPage clickOnWikipediaPage() {
       officialCandidatesPage.click();
        return new WikipediaPage(testClass);
    }

    public CandidatesPage clickButtonOnCandidatesPage() {
        scrollByPageElement(buttonVoiteOnCandidatesPage);
        clickOnElementByPage(buttonVoiteOnCandidatesPage);
        return this;
    }

    public CandidatesPage closeAboutPage() {
        closeButton.click();
        return this;
    }

    public BallotPage openBalletPage() {
        buttonYes.click();
        return new BallotPage(testClass);
    }


}
