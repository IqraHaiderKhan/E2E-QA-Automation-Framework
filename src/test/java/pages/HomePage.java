
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.id("small-searchterms");
    private By searchBtn = By.cssSelector("input.button-1.search-box-button");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public void search(String keyword){
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(keyword);
        driver.findElement(searchBtn).click();
    }
}
