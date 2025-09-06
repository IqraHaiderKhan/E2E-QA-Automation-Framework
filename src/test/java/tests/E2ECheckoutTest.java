package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void addItemToCart_flow() {
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Wait until product appears
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-item")));

        boolean resultsShown = driver.findElements(By.cssSelector(".product-item")).size() > 0;
        Assert.assertTrue(resultsShown, "No products were found after search!");
    }
}
