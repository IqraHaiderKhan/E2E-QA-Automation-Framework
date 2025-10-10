package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutPositiveTest extends BaseTest {

    @Test
    public void checkoutWithValidDetails_shouldSucceed() {
        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Verify login worked
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed! Not on inventory page."
        );

        // 2️⃣ Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();

        // 3️⃣ Start checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 4️⃣ Fill checkout form
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm("Iqra", "Khan", "12345");
        checkoutPage.clickContinue();

        // 5️⃣ Verify we move to next page (overview step)
        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two.html"),
                "Checkout did not proceed to step two!"
        );
    }
}



