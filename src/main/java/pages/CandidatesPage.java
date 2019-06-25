package pages;

import base.BaseTest;
import components.CandidateDetailsPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage extends AbstractTablePage {

    @FindBy(xpath = "//div[contains(@class, 'list-option-description')]")
    private WebElement wikiInfo;

    @FindBy(xpath = "//a[.='Official candidate page']")
    private WebElement officialCandidatePageLink;


    public CandidatesPage(BaseTest testClass) {
        super(testClass);
    }


    public String getWikiInfo() {
        return testClass.waitTillElementIsVisible(wikiInfo).getText();
    }

    public String getWikiLink() {
        return testClass.waitTillElementIsVisible(officialCandidatePageLink)
                .getAttribute("href");
    }

    public <T extends AbstractPage> T voteInElection(Class<T> pageToReturn) {
        CandidateDetailsPopup candidateDetailsPopup = clickVoteInElectionsButton(CandidateDetailsPopup.class);
        return candidateDetailsPopup.clickOk(pageToReturn);
    }

}
