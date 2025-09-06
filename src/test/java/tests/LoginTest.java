package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin_flow() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();

        loginPage.login("testuser@example.com", "Password123");

        // Validate successful login
        Assert.assertTrue(homePage.isLogoutLinkVisible(), "Login failed!");
    }
}
