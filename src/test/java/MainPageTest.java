import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import parentForPages.BasePage;
import parentForTests.BaseTest;

public class MainPageTest{

    MainPage mainPage;
    BaseTest baseTest;

    public MainPageTest(MainPage mainPage, BaseTest baseTest) {
        this.mainPage = mainPage;
        this.baseTest = baseTest;
    }


    @BeforeMethod
    public void openPage() {
        baseTest.openPage();
    }

    @Test
    public void mustOpenThisPage() {
        mainPage.downloadMainPage();
        Assert.assertTrue(true);
    }


}
