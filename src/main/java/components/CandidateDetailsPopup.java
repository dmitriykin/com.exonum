package components;

import base.BaseTest;
import enums.ActionButton;

public class CandidateDetailsPopup extends AbstractPopupPage {

    public CandidateDetailsPopup(BaseTest testClass) {
        super(testClass, ActionButton.YES, ActionButton.CANCEL);
    }
}


