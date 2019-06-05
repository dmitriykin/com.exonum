package pages;

import main.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends TestBase{

    PageElections pageElections;

    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoteInElection;
    @FindBy(xpath = "//div[text()='Monitor election process']")
    private WebElement buttonMonitor;
    @FindBy(xpath = "//div[text()='e-Voting']")
    private WebElement textPage;

    public boolean checkTitleThisPage() {
        String title = getDriver().getTitle();
        if (title.equals("Voting App")) {
            return true;
        } else {
            return false;
        }
    }

    public MainPage checkTextPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By)textPage));
        return this;
    }

    public MainPage mainPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return document.readyState").toString().equals("complete");
        return this;
    }

    public PageElections clickButtonVoteInElection() {
       wait.until(ExpectedConditions.visibilityOfElementLocated((By)buttonVoteInElection)).click();
        return new PageElections();
    }

    public PageElections clickButtonMonitor() {
       wait.until(ExpectedConditions.visibilityOfElementLocated((By)buttonMonitor)).click();
        return new PageElections();
    }




}
