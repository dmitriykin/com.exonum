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


    private WebElement okButton;
    private WebElement cancelButton;
    private WebElement saveButton;
    private WebElement discardButton;
    private WebElement decryptButton;
    private WebElement signButton;



    public AbstractPopupPage(BaseTest testClass, ActionButton okButton, ActionButton cancelButton) {
        super(testClass);
        initButton(okButton, cancelButton);
    }

    public AbstractPopupPage(BaseTest testClass, ActionButton saveButton, ActionButton discardButton, ActionButton decryptButton, ActionButton signButton) {
        super(testClass);
        initButton(saveButton, discardButton, decryptButton, signButton);
    }

    public void initButton(ActionButton saveButton, ActionButton discardButton, ActionButton decryptButton, ActionButton signButton) {
        WebDriver driver = testClass.getDriver();
        String xpath = "//div[contains(@class, 'button') and .='%s']";
        if (saveButton != null)
            this.saveButton = driver.findElement(By.xpath(String.format(xpath, saveButton.getLabel())));
        if (discardButton != null)
            this.discardButton = driver.findElement(By.xpath(String.format(xpath, discardButton.getLabel())));
        if(decryptButton != null)
            this.decryptButton = driver.findElement(By.xpath(String.format(xpath, decryptButton.getLabel())));
        if (signButton != null)
            this.signButton = driver.findElement(By.xpath(String.format(xpath, signButton.getLabel())));
    }

    public void initButton(ActionButton okButton, ActionButton cancelButton) {
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
