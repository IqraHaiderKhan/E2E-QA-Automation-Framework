package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void checkoutWithValidDetails_shouldSucceed() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed!");

        // Add item
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();

        // Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm("Iqra", "Khan", "12345");
        checkoutPage.clickContinue();

        // Verify step two
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), "Did not reach step two!");
    }
}
