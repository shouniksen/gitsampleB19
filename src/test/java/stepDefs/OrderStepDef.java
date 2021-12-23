package stepDefs;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class OrderStepDef extends TestBase {

	HomePage homePage;
	SearchResultPage resultPage;

	@Before
	public void setUp() {
		initialize();
		homePage = new HomePage();
		resultPage = new SearchResultPage();
	}

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		String pageTitle = homePage.isHomePage();
		Assert.assertEquals("Your Store", pageTitle);

	}

	@When("User search {string}")
	public void user_search(String strItem) {
		homePage.searchItem(strItem);
	}

	@When("Add Item to cart")
	public void add_item_to_cart() {
		resultPage.addToCart();
	}

	@Then("Item must be in cart")
	public void item_must_be_in_cart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isItemAdded = resultPage.isItemAdded();
		Assert.assertTrue(isItemAdded);

	}

}
