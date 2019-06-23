package parentForPages;

import abstractForPages.AbstractPage;
import org.openqa.selenium.WebElement;
import parentForTests.BaseTest;

public abstract class BasePage extends AbstractPage {

    public BasePage(BaseTest testClass) {
        super(testClass);
    }

    protected boolean isSelectedByElement(WebElement element) {
        return element.isSelected();
    }

    protected boolean isEnabledElement(WebElement element) {
        return element.isEnabled();
    }


}

