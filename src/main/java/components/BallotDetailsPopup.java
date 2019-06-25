package components;

import base.BaseTest;

public class BallotDetailsPopup extends AbstractPopupPage {

    public BallotDetailsPopup(BaseTest testClass) {
        super(testClass, ActionButton.SAVE, ActionButton.DISCARD, ActionButton.DECRYPT, ActionButton.SIGN);
    }
}
