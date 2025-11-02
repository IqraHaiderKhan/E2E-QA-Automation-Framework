package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.utils.ExtentTestManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().pass("Test passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().skip("Test skipped");
        }
    }

    @Override
    public void onStart(ITestContext context) { }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
    }
}
