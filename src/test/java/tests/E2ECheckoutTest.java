package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;

public class E2ECheckoutTest extends BaseTest {

@Test
public void addItemToCart_flow() {
    // Login
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");

    // 🔹 Verify login worked
    Assert.assertTrue(
        driver.getCurrentUrl().contains("inventory.html"),
        "Login failed! Not on inventory page."
    );

    // Add item
    InventoryPage inventoryPage = new InventoryPage(driver);
    inventoryPage.addFirstItemToCart();
    inventoryPage.goToCart();

    // Checkout
    CartPage cartPage = new CartPage(driver);
    cartPage.clickCheckout();
}
}
