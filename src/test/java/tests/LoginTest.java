package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin_flow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Assert user is redirected to inventory page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "User was not redirected to inventory page after login");
    }
}






