
package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void addItemToCart_flow() throws Exception {
        driver.get("https://demo.nopcommerce.com/");

        // Debug info
        System.out.println("DEBUG: Page URL after load = " + driver.getCurrentUrl());
        System.out.println("DEBUG: Page Title = " + driver.getTitle());

        // Take screenshot for CI
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("target/homepage.png"));

        // Dump page source (first 500 chars only)
        String pageSource = driver.getPageSource();
        System.out.println("DEBUG: Page source snippet = " +
            pageSource.substring(0, Math.min(pageSource.length(), 500)));

        // Now wait for search box
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms"))
        );

        searchBox.sendKeys("laptop");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
