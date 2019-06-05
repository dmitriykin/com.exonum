package pages;

import main.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends TestBase{

    PageElections pageElections;

    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoteInElection;
    @FindBy(xpath = "//div[text()='Monitor election process']")
    private WebElement buttonMonitor;

    public void mainPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return document.readyState").toString().equals("complete");
    }

    public PageElections clickButtonVoteInElection() {
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated((By)buttonVoteInElection)).click();
        return new PageElections();
    }

    public PageElections clickButtonMonitor() {
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated((By)buttonMonitor)).click();
        return new PageElections();
    }




}
