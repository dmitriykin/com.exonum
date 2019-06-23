package pages;

import allTable.AllTablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentForTests.BaseTest;


public class ElectionsPage extends AllTablePage {

    protected MainPage mainPage;
    protected CandidatesPage CandidatesPage;

    @FindBy(xpath = "//span[text()='e-Voting']")
    private WebElement textEVoting;
    @FindBy(xpath = "//div[@class='toolbar-return-button pull-left']")
    private WebElement returnButton;
    @FindBy(xpath = "//div[text()='HELP']")
    private WebElement buttonHelp;
    @FindBy(xpath = "//table[@class='app-list']")
    private WebElement tableOnElectionsPage;
    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoite;

    public ElectionsPage(BaseTest testClass) {
        super(testClass);
    }

    public MainPage returnOnMainPage() {
        scrollByElementAndClick(returnButton);
        return new MainPage(testClass);
    }

    public ElectionsPage clickButtonHelp() {
        scrollByElementAndClick(buttonHelp);
        return this;
    }

    public ElectionsPage choiceRegion(int number) {
        rows(tableOnElectionsPage);
        checkElements(number);
        return this;
    }

    public CandidatesPage openCandidatesPage() {
        scrollByElementAndClick(buttonVoite);
        return new CandidatesPage(testClass);
    }


}
