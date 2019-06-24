package pages;

import base.BaseTest;

public class MainPage extends BasePage {

    public MainPage(BaseTest testClass) {
        super(testClass);
    }


    public ElectionsPage clickVoteInElections() {
        testClass.waitTillClickableAndClickElement(voteInElectionsButton);
        return new ElectionsPage(testClass);
    }

}
