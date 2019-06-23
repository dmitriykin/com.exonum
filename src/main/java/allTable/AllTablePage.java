package allTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import parentForPages.BasePage;
import parentForTests.BaseTest;

import java.util.List;

public class AllTablePage extends BasePage {

    public AllTablePage(BaseTest testClass) {
        super(testClass);
    }

    protected List<WebElement> rows(WebElement choiceTable) {
        List<WebElement> row = choiceTable.findElements(By.xpath(".//tr"));
        return row;
    }

    public AllTablePage checkElements(int number) {
        WebElement row = rows((WebElement) this).get(number - 1);
        if (!row.isSelected()) {
            row.click();
        }
        return this;
    }

}
