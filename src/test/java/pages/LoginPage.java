package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // 🔹 Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // 🔹 Click login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // 🔹 Combined login method
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // 🔹 Get error message (for negative login tests)
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

