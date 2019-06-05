package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    PageElections pageElections;

    @FindBy(xpath = "//div[text()='VOTE IN ELECTION']")
    private WebElement buttonVoteInElection;
    @FindBy(xpath = "//div[text()='Monitor election process']")
    private WebElement buttonMonitor;

    public PageElections clickButtonVoteInElection() {
        buttonVoteInElection.click();
        return new PageElections();
    }

    public PageElections clickButtonMonitor() {
        buttonMonitor.click();
        return new PageElections();
    }


}
