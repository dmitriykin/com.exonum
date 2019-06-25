package pages;

import base.BaseTest;
import components.BallotDetailsPopup;

public class BallotPage extends BallotDetailsPopup {

    public BallotPage(BaseTest testClass) {
        super(testClass);
    }

    public <T extends AbstractPage> T clickButtons(Class<T> pageToReturn) {
        BallotDetailsPopup ballotDetailsPopup = clickSign(BallotDetailsPopup.class);
        return createPage(pageToReturn);

    }
}
