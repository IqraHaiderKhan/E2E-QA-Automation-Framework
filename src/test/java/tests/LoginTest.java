package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin_shouldGoToInventory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        // ✅ Verify login success by checking URL
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed! Not on inventory page."
        );
    }

    @Test
    public void invalidLogin_wrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_pass");

        // ✅ Assert error message is shown
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error message not shown for wrong password."
        );
    }

    @Test
    public void invalidLogin_emptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        // ✅ Assert error message is shown
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username is required"),
                "Expected error message not shown for empty login fields."
        );
    }
}







