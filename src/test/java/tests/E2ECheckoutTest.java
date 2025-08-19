
package tests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void addItemToCart_flow() {
        HomePage home = new HomePage(driver);
        home.search("computer");
        SearchResultsPage results = new SearchResultsPage(driver);
        results.addFirstResultToCart();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("shopping cart") 
                || driver.getCurrentUrl().toLowerCase().contains("cart"));
    }
}
