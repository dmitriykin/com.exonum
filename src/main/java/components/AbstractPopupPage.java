package components;

import base.BaseTest;
import com.googlecode.junittoolbox.PollingWait;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPopupPage extends AbstractComponent {

    private WebElement okButton;
    private WebElement cancelButton;
    private String rootXpath = "";


    public AbstractPopupPage(BaseTest testClass, ActionButton okButton, ActionButton cancelButton) {
        super(testClass);
        initButtons(okButton, cancelButton);
    }

    public AbstractPopupPage(BaseTest testClass, ActionButton signButton, ActionButton cancelButton, String rootXpath) {
        super(testClass);
        this.rootXpath = rootXpath;
        initButtons(signButton, cancelButton);

    }

    public AbstractPopupPage(BaseTest testClass) {
        super(testClass);
    }


    public void initButtons(ActionButton okButton, ActionButton cancelButton) {
        WebDriver driver = testClass.getDriver();
        String xpath = rootXpath + "//div[contains(@class, 'button') and .='%s']";
        if(okButton != null)
            this.okButton = driver.findElement(By.xpath(String.format(xpath, okButton.getLabel())));
        if(cancelButton != null)
            this.cancelButton = driver.findElement(By.xpath(String.format(xpath, cancelButton.getLabel())));
}


    public <T extends AbstractPage> T clickOk(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, okButton);
    }

    public <T extends AbstractPage> T clickCancel(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, cancelButton);
    }


    private <T extends AbstractPage> T clickButtonAndReturnPage(Class<T> pageToReturn, WebElement button) {
        testClass.waitTillClickableAndClickElement(button);
        return createPage(pageToReturn);
    }

}
