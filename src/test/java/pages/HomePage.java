package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By loginLink = By.className("ico-login");
    private By logoutLink = By.className("ico-logout");
    private By registerLink = By.className("ico-register");
    private By searchField = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button.search-box-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Existing ---
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public boolean isLogoutLinkVisible() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    // --- 🔹 Missing methods ---
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void search(String productName) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(productName);
        driver.findElement(searchButton).click();
    }
}

