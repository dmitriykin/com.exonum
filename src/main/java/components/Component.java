package components;

import base.BaseTest;
import pages.*;

public class Component extends CandidatesPage{

    public Component(BaseTest testClass) {
        super(testClass);
    }

    protected BallotPage apply() {
        yesButton.click();
        return new BallotPage(testClass);
    }

    public CandidatesPage cancel() {
        cancelButton.click();
        return this;
    }

}
