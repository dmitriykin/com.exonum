package components;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

public abstract class AbstractPopupPage extends AbstractComponent {

     enum ActionButton {

        YES("YES"),
        CANCEL("CANCEL"),
        SAVE("Save 3-word memo and ballot hash"),
        DISCARD("DISCARD"),
        DECRYPT("DECRYPT"),
        SIGN("SIGN");

        private final String label;

        ActionButton(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
        }

    private WebDriver driver = testClass.getDriver();
    private WebElement okButton;
    private WebElement cancelButton;
    private WebElement saveButton;
    private WebElement discardButton;
    private WebElement decryptButton;
    private WebElement signButton;



    public AbstractPopupPage(BaseTest testClass, ActionButton okButton, ActionButton cancelButton) {
        super(testClass);
        String buttonLocator = "//div[contains(@class, 'button') and .='%s']";
        this.okButton = driver.findElement(By.xpath(String.format(buttonLocator, okButton.getLabel())));
        this.cancelButton = driver.findElement(By.xpath(String.format(buttonLocator, cancelButton.getLabel())));
    }

    public void initButton(ActionButton saveButton, ActionButton discardButton, ActionButton decryptButton, ActionButton signButton) {
        String Xpath = "//div[contains(@class, 'button') and .='%s']";
        this.saveButton = driver.findElement(By.xpath(String.format(Xpath, saveButton.getLabel())));
        this.discardButton = driver.findElement(By.xpath(String.format(Xpath, discardButton.getLabel())));
        this.decryptButton = driver.findElement(By.xpath(String.format(Xpath, decryptButton.getLabel())));
        this.signButton = driver.findElement(By.xpath(String.format(Xpath, signButton.getLabel())));
    }

    public AbstractPopupPage(BaseTest testClass, ActionButton saveButton, ActionButton discardButton, ActionButton decryptButton, ActionButton signButton) {
        super(testClass);
        initButton(saveButton, discardButton, decryptButton, signButton);
    }

    public <T extends AbstractPage> T clickOk(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, okButton);
    }

    public <T extends AbstractPage> T clickCancel(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, cancelButton);
    }

    public <T extends AbstractPage> T clickSaveButton(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, saveButton);
    }

    public <T extends AbstractPage> T clickDiscardButton(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, discardButton);
    }

    public <T extends AbstractPage> T clickDecryptButton(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, decryptButton);
    }

    public <T extends AbstractPage> T clickSign(Class<T> pageToReturn) {
        return clickButtonAndReturnPage(pageToReturn, signButton);
    }

    private <T extends AbstractPage> T clickButtonAndReturnPage(Class<T> pageToReturn, WebElement button) {
        testClass.scrollToElementByJsAndClick(button);
        return createPage(pageToReturn);
    }
}
