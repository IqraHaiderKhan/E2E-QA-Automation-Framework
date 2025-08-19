
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void addItemToCart_flow() {
        driver.get("https://demo.nopcommerce.com/"); // ✅ ensure we open the right site

        // Debug info
        System.out.println("Page URL after load: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        // Wait for search box to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms"))
        );

        // Perform action
        searchBox.sendKeys("laptop");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Add extra wait for results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-item")));

        // Verify at least one product appears
        int productCount = driver.findElements(By.cssSelector(".product-item")).size();
        System.out.println("Products found: " + productCount);

        Assert.assertTrue(productCount > 0, "No products found in search results");
    }
}
