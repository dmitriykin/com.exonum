package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentForPages.BasePage;
import parentForTests.BaseTest;

import java.util.List;


public class ElectionsPage extends BasePage {

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
        returnButton.click();
        return new MainPage(testClass);
    }

    public ElectionsPage clickButtonHelp() {
        buttonHelp.click();
        return this;
    }

    protected List<WebElement> rows() {
        List<WebElement> row = tableOnElectionsPage.findElements(By.xpath(".//tr"));
        return row;
    }

    public ElectionsPage checkElements(int number) {
        WebElement row = rows().get(number - 1);
        if (!row.isSelected()) {
            row.click();
        }
        return this;
    }

    public CandidatesPage openCandidatesPage() {
        buttonVoite.click();
        return new CandidatesPage(testClass);
    }


}
