package tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    private long startTime; // ⏱️ Track test start time

    @BeforeSuite
    public void startReport() {
        ExtentManager.getInstance(); // initialize report once
        addSystemInfo(); // 🔹 Add environment details
    }

    private void addSystemInfo() {
        try {
            Properties props = System.getProperties();
            RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();

            ExtentManager.getInstance().setSystemInfo("Browser", "Chrome");
            ExtentManager.getInstance().setSystemInfo("OS", props.getProperty("os.name") + " " + props.getProperty("os.version"));
            ExtentManager.getInstance().setSystemInfo("Java Version", props.getProperty("java.version"));
            ExtentManager.getInstance().setSystemInfo("User", props.getProperty("user.name"));
            ExtentManager.getInstance().setSystemInfo("Execution Time", runtimeMxBean.getStartTime() + "");
        } catch (Exception e) {
            System.out.println("⚠️ Unable to add system info: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
        startTime = System.currentTimeMillis();

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
            long duration = System.currentTimeMillis() - startTime;
            ExtentManager.getTest().info("⏱️ Test Duration: " + duration + " ms");

            try {
                if (result.getStatus() == ITestResult.FAILURE) {
                    String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
                    ExtentManager.getTest().fail("❌ Test Failed: " + result.getThrowable(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath, "📸 View Screenshot").build());
                } else if (result.getStatus() == ITestResult.SUCCESS) {
                    ExtentManager.getTest().pass("✅ Test Passed");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    ExtentManager.getTest().skip("⚠️ Test Skipped");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error while logging result: " + e.getMessage());
            }

            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.getInstance().flush();
        openReport(); // 🚀 Auto-open Extent Report after all tests
    }

    private void openReport() {
        try {
            File reportFile = new File("test-output/ExtentReport.html");
            if (reportFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.toURI());
                System.out.println("📊 Extent Report opened successfully: " + reportFile.getAbsolutePath());
            } else {
                System.out.println("⚠️ Report not found or desktop browse not supported.");
            }
        } catch (IOException e) {
            System.out.println("❌ Failed to open Extent Report automatically: " + e.getMessage());
        }
    }
}

