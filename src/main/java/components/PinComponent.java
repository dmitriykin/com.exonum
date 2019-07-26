package components;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SignedPage;

import java.util.List;

public class PinComponent extends AbstractPopupPage {

    private static final String AREA_XPATH = "//div[contains(@class, 'modal-decrypt-dark')]";

    public PinComponent(BaseTest testClass) {
        super(testClass, ActionButton.SIGN_BALLOT, ActionButton.CANCEL, AREA_XPATH);
    }

    private WebElement pinCodeButtons(int digit) {
        WebDriver driver = testClass.getDriver();
        String xpathForDigits = "//div[@class='keyboard-button-digit' and .='%d']";
        return driver.findElement(By.xpath((String.format(xpathForDigits, digit))));
    }

    public <T extends AbstractPopupPage> T clickPinButtons(List<Integer> digits, Class<T> pageToReturn) {
        for (Integer digit : digits) {
            testClass.waitTillClickableAndClickElement(pinCodeButtons(digit));
        }
        return clickOk(pageToReturn);
    }


}
