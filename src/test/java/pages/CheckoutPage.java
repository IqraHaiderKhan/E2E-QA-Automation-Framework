package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");

    private By checkoutOverviewTitle = By.className("title");
    private By successMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerInfo(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void finishCheckout() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(finishBtn))
            .click();
    }
    public void clickContinue() {
    driver.findElement(continueBtn).click();
}

    // ✅ Validation helpers
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getOverviewTitle() {
        return driver.findElement(checkoutOverviewTitle).getText();
    }
}




