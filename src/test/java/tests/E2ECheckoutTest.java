
package tests;

import tests.BaseTest;
import org.testng.annotations.Test; 
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

    // Wait for page load complete
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
        wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
    );

    // Wait for search box to be clickable
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement searchBox = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("small-searchterms"))
    );

    searchBox.sendKeys("laptop");
    driver.findElement(By.cssSelector("button[type='submit']")).click();
}
}