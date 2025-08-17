package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("validUser"); // TODO: replace with a valid username
        loginPage.enterPassword("validPass"); // TODO: replace with a valid password
        loginPage.clickLogin();

        // Basic positive assertion — update the condition to match your app's behavior
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), 
                "Expected to land on dashboard after successful login");
    }
}
