package pages;

import main.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageElections extends TestBase {

    MainPage mainPage;
    PageCandidates pageCandidates;

    @FindBy(xpath = "//span[text()='e-Voting']")
    private WebElement textEVoting;
    @FindBy(xpath = "//div[@class='toolbar-return-button pull-left']")
    private WebElement returnButton;
    @FindBy(xpath = "//div[text()='HELP']")
    private WebElement buttonHelp;
    @FindBy(xpath = "//table[@class='app-list']")
    private WebElement table;
    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoite;

    public PageElections checkTextEVoting() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) textEVoting));
        return this;
    }

    public MainPage returnOnMainPage() {
        returnButton.click();
        return new MainPage();
    }

    public PageElections clickButtonHelp() {
        buttonHelp.click();
        return this;
    }

    public List<WebElement> rows() {
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        return rows;
    }

    public PageElections checkElements(int number) {
        WebElement row = rows().get(number - 1);
        if (!row.isSelected()) {
            row.click();
        }
        return this;
    }

    public PageCandidates clickButtonVoit() {
        buttonVoite.click();
        return new PageCandidates();
    }




}
