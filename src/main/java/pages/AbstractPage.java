package pages;

import base.BaseTest;
import constants.WaitConstant;
import lombok.extern.java.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

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
    protected <T extends AbstractPage> T createPage(Class<T> clazz) {
        return createPage(clazz, null);
    }

    protected <T extends AbstractPage> T createPage(Class<T> clazz, String param) {
        if (param != null)
            try {
                return clazz.getConstructor(BaseTest.class, String.class).newInstance(testClass, param);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot create object of class: " + clazz.getName() + ", with param: " + param);
            }
        else {
            try {
                return clazz.getConstructor(BaseTest.class).newInstance(testClass);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot create object of class: " + clazz.getName());
            }
        }
    }

}
