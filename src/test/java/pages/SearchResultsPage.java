
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private By addToCartButtons = By.cssSelector("input[value='Add to cart']");

    public SearchResultsPage(WebDriver driver){ this.driver = driver; }

    public void addFirstResultToCart(){
        List<WebElement> btns = driver.findElements(addToCartButtons);
        if (!btns.isEmpty()) {
            btns.get(0).click();
        }
    }
}
