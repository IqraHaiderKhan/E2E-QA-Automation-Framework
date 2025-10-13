package tests;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;
import utils.ExtentManager;
import utils.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void startReport() {
        ExtentManager.getInstance(); // initialize report once
    }

    @BeforeMethod
    public void setUp(ITestResult result) {
        // ✅ Create Extent test for each test method
        ExtentManager.createTest(result.getMethod().getMethodName());

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
                ExtentManager.getTest().fail("❌ Test Failed: " + result.getThrowable());
                ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                ExtentManager.getTest().pass("✅ Test Passed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                ExtentManager.getTest().skip("⚠️ Test Skipped");
            }
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.getInstance().flush(); // ✅ Generate final report at the end
    }
}
