package listeners;

import lombok.extern.java.Log;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@Log
public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        logMessage(tr, "started");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logMessage(tr, "failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logMessage(tr, "skipped");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logMessage(tr, "succeed");
    }

    private void logMessage(ITestResult tr, String status) {
        log.info(tr.getName() + String.format(" -- Test method %s\n", status));
    }

}
