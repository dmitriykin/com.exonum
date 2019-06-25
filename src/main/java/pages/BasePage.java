package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//div[.='VOTE IN ELECTION']")
    protected WebElement voteInElectionsButton;


    public BasePage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickVoteInElectionsButton(Class<T> pageToReturn) {
        testClass.waitTillClickableAndClickElement(voteInElectionsButton);
        return createPage(pageToReturn);
    }

}

