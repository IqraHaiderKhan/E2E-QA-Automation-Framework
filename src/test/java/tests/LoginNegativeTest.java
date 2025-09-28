package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void invalidUsername_shouldShowError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "secret_sauce");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"),
                "Expected error for invalid username, but got: " + error);
    }

    @Test
    public void invalidPassword_shouldShowError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_pass");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"),
                "Expected error for invalid password, but got: " + error);
    }

    @Test
    public void emptyFields_shouldShowError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username is required"),
                "Expected error for empty fields, but got: " + error);
    }
}




