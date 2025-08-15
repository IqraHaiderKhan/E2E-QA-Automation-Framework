
package mobileTests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidSampleTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("Android Emulator")
                .setAppPackage("com.android.calculator2")
                .setAppActivity(".Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) driver.quit();
    }

    @Test
    public void sample_calc(){
        WebElement two = driver.findElement(AppiumBy.accessibilityId("2"));
        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        WebElement two2 = driver.findElement(AppiumBy.accessibilityId("2"));
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        two.click(); plus.click(); two2.click(); equals.click();
        WebElement result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
        Assert.assertTrue(result.getText().contains("4"));
    }
}
