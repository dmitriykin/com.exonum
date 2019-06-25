package components;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

public abstract class AbstractPopupPage extends AbstractComponent {

    enum ActionButton {
        YES("YES"),
        CANCEL("CANCEL");

        private final String label;

        ActionButton(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private WebElement okButton;
    private WebElement cancelButton;


    public AbstractPopupPage(BaseTest testClass, ActionButton okButton, ActionButton cancelButton) {
        super(testClass);
        String buttonLocator = "//div[contains(@class, 'button') and .='%s']";
        this.okButton = testClass.getDriver().findElement(By.xpath(String.format(buttonLocator, okButton.getLabel())));
        this.cancelButton = testClass.getDriver().findElement(By.xpath(String.format(buttonLocator, cancelButton.getLabel())));
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
