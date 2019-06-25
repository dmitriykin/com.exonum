package pages;

import base.BaseTest;
import com.googlecode.junittoolbox.PollingWait;
import constants.WaitConstant;
import enums.TableEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTablePage extends BasePage {

    public AbstractTablePage(BaseTest testClass) {
        super(testClass);
    }


    protected List<WebElement> getListRows() {
        return testClass.getDriver().findElements(By.xpath("//tr"));
    }


    public void selectListRow(TableEntry entry) {
        List<WebElement> listRows = waitForTableToBeLoad();
        listRows.forEach(r -> {
            if (r.getText().contains(entry.getLabel()))
                r.click();
        });
    }

    public CandidatesPage selectListRowAndClick(TableEntry entry) {
        selectListRow(entry);
        List<WebElement> tableRows = getListRows();
        testClass.scrollToElementByJsAndClick(voteInElectionsButton);
        tableRows.forEach(rt -> {
            if (rt.getText().contains(entry.getLabel()))
                testClass.waitTillElementIsInvisible(rt);
        });
        return new CandidatesPage(testClass);
    }


    protected List<WebElement> waitForTableToBeLoad() {
        new PollingWait()
                .pollEvery(2, TimeUnit.SECONDS)
                .timeoutAfter(WaitConstant.LONG_TIMEOUT, TimeUnit.SECONDS)
                .until(() -> getListRows().size() > 0);
        return getListRows();
    }

    public int getListSize() {
        return waitForTableToBeLoad().size();
    }

}
