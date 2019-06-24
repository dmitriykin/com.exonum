package pages;

import base.BaseTest;
import constant.WaitConstant;
import lombok.extern.java.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log
public abstract class AbstractPage {

    protected BaseTest testClass;

    public AbstractPage(BaseTest testClass) {
        log.info(String.format(">>> Initializing <%s> <<<", this.getClass().getSimpleName()));
        this.testClass = testClass;
        waitForLoad();
        PageFactory.initElements(this.testClass.getDriver(), this);
    }

    public void waitForLoad() {
        waitForLoad(WaitConstant.LONG_TIMEOUT);
    }

    public void waitForLoad(long timeoutInSeconds) {
        new WebDriverWait(testClass.getDriver(), timeoutInSeconds).until(d ->
                ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

}
