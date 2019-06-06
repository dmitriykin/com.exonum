package parentForPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentForTests.BaseTest;

public abstract class BasePage{

    protected BaseTest testClass;
    protected WebDriverWait wait = new WebDriverWait(testClass.getDriver(), 30);

    public BasePage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(this.testClass.getDriver(), this);
    }

    public void scrollByPageElement(WebElement elementForScrolling) {
        JavascriptExecutor js = (JavascriptExecutor) testClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", testClass.getDriver().findElement((By) elementForScrolling));
    }

    public void clickOnElementByPage(WebElement elementForClick) {
        if (elementForClick.isDisplayed()) {
            elementForClick.click();
        }

    }








}
