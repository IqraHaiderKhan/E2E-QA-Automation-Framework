package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "target/screenshots/" + testName + ".png";

            Files.createDirectories(Paths.get("target/screenshots"));

            Files.copy(screenshot.toPath(), Paths.get(filePath));
            System.out.println("Saved screenshot: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
