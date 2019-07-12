package components;

import base.BaseTest;
import enums.ActionButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

public abstract class AbstractPopupPage extends AbstractComponent {

    private WebElement okButton;
    private WebElement cancelButton;


    public AbstractPopupPage(BaseTest testClass, ActionButton okButton, ActionButton cancelButton) {
        super(testClass);
        createButton(okButton, cancelButton);
    }

    public void createButton(ActionButton okButton, ActionButton cancelButton) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
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
