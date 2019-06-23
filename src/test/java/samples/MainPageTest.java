package samples;

import org.testng.annotations.*;
import parentForTests.BaseTest;


public class MainPageTest extends BaseTest{

    @BeforeSuite
    public void setupSystemProperty() {
        choiceOS();
    }

    @BeforeClass
    public void openBrowser() {
        createBrowser();
    }

    @BeforeMethod
    public void openURL() {
        openPage();
        waitForLoad();
        turnOnImplicitWait();
    }

    @Test
    public void mustOpenThisPage() {

    }


}
