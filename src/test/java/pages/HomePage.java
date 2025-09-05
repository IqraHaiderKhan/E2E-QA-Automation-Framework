package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By inventoryContainer = By.id("inventory_container");
    private By firstAddToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartLink = By.className("shopping_cart_link");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean isProductListDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
