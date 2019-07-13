package components;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PinComponent extends AbstractPopupPage {

    public PinComponent(BaseTest testClass, ActionButton signButton, ActionButton cancelButton, String rootXpath) {
        super(testClass, signButton, cancelButton, rootXpath);
    }

    private WebElement getPinDigit(int digit) {
        WebDriver driver = testClass.getDriver();
        String xpathForDigits = "//div[@class='keyboard-button-digit' and .='%s']";
        return driver.findElement(By.xpath(String.format(String.format(xpathForDigits, String.valueOf(digit)))));
    }

    public PinComponent pin(List<Integer> digits) {
        for (Integer digit : digits) {
            testClass.waitTillClickableAndClickElement(getPinDigit(digit));
        }
        return this;
    }


}
