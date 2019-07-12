package components;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PinComponent extends AbstractPopupPage {

    public PinComponent(BaseTest testClass, ActionButton signButton, ActionButton cancelButton, String rootXpath) {
        super(testClass, signButton, cancelButton, rootXpath);
    }

    protected void clickPinCodeButton(List<Integer> digits) {
        WebDriver driver = testClass.getDriver();
        String xpathForDigits = "//div[@class='keyboard-button-digit' and .='%s']";
        testClass.waitTillClickableAndClickElement(okButton);
    }


}
