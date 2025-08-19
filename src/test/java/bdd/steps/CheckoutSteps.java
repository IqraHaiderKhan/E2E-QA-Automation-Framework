
package bdd.steps;

import tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class CheckoutSteps extends BaseTest {
    HomePage home;
    SearchResultsPage results;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        home = new HomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        home.search(keyword);
    }

    @When("I add the first result to the cart")
    public void i_add_the_first_result_to_the_cart() {
        results = new SearchResultsPage(driver);
        results.addFirstResultToCart();
    }

    @Then("I should see the cart page or a cart indicator")
    public void i_should_see_the_cart_page_or_a_cart_indicator() {
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("cart") 
            || driver.getPageSource().toLowerCase().contains("shopping cart"));
    }
}
