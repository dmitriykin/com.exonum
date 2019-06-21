package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import parentForPages.BasePage;
import parentForTests.BaseTest;


public class MainPage extends BasePage {

   protected ElectionsPage ElectionsPage;

    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoteInElection;
    @FindBy(xpath = "//div[text()='Monitor election process']")
    private WebElement buttonMonitor;
    @FindBy(xpath = "//div[text()='e-Voting']")
    private WebElement textPage;

    public MainPage(BaseTest testClass) {
        super(testClass);
    }

    public boolean checkTitleThisPage() {
        String title = testClass.getDriver().getTitle();
        if (title.equals("Voting App")) {
            return true;
        } else {
            return false;
        }
    }

    public MainPage downloadMainPage() {
        JavascriptExecutor js = (JavascriptExecutor) testClass.getDriver();
        js.executeScript("return document.readyState").toString().equals("complete");
        return this;
    }

    public ElectionsPage clickButtonVoteInElection() {
        buttonVoteInElection.click();
        return new ElectionsPage(testClass);
    }

    public ElectionsPage clickButtonMonitor() {
        buttonMonitor.click();
        return new ElectionsPage(testClass);
    }




}
