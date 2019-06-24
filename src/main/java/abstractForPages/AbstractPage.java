package abstractForPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import parentForTests.BaseTest;

public abstract class AbstractPage {
//test
    protected BaseTest testClass;

    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(this.testClass.getDriver(), this);
    }

    protected void scrollByPageElement(WebElement elementForScrolling) {
        JavascriptExecutor js = (JavascriptExecutor) testClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", testClass.getDriver().findElement((By) elementForScrolling));
    }

    protected void scrollByElementAndClick(WebElement elementForClick) {
        scrollByPageElement(elementForClick);
        if (elementForClick.isDisplayed()) {
            elementForClick.click();
        }

    }
}
