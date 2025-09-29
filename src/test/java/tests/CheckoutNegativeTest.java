package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutNegativeTest extends BaseTest {

    @Test
    public void checkoutWithoutFillingForm_shouldShowError() {
        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Verify login worked
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed! Not on inventory page."
        );

        // 2️⃣ Add an item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();

        // 3️⃣ Start checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 4️⃣ Don’t enter any info, just click continue
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinue();

        // 5️⃣ Verify error message
        String error = checkoutPage.getErrorMessage();
        Assert.assertTrue(
                error.contains("Error") || error.contains("First Name"),
                "Expected error message but got: " + error
        );
    }
}




