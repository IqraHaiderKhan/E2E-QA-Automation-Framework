package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Clicks the first "Add to cart" button
    public void addFirstItemToCart() {
        WebElement firstAddToCartButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_inventory"))
        );
        firstAddToCartButton.click();
    }

    public void goToCart() {
    WebElement cartIcon = wait.until(
        ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))
    );
    System.out.println("✅ Found cart icon, clicking...");
    cartIcon.click();

    // Debug current URL
    System.out.println("🔎 After clicking cart, current URL: " + driver.getCurrentUrl());

    // Debug page title
    System.out.println("🔎 Page title: " + driver.getTitle());

    // Debug cart badge (if item added)
    try {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("🛒 Cart badge count: " + badge.getText());
    } catch (Exception e) {
        System.out.println("⚠️ No cart badge found — maybe item wasn’t added.");
    }

    wait.until(ExpectedConditions.urlContains("cart.html"));
}
    }

