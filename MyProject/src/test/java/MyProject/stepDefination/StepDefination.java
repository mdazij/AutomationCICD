package MyProject.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import MyProject.PageObjects.CartPage;
import MyProject.PageObjects.CheckoutPage;
import MyProject.PageObjects.ConfirmationPage;
import MyProject.PageObjects.LandingPage;
import MyProject.PageObjects.ProductCatalogue;
import MyProject.testComponent.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public ConfirmationPage confirmationpage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingpage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_password(String username, String password) {
		productcatalogue = landingpage.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String ProductName) throws InterruptedException {
		productcatalogue.addProductToCart(ProductName);
	}

	@And("^Checkout product (.+) and submit the order$")
	public void Checkout_product_and_submit_order(String ProductName) {
		CartPage cartpage = productcatalogue.goToCart();
		Boolean match = cartpage.verifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.submitOrder();
	}

	@Then("{string} message displayed on confirmation page")
	public void message_displayed_on_confirmation_page(String string) {
		String confirmationmsg = confirmationpage.getConfirmationPage();
		Assert.assertTrue(confirmationmsg.equalsIgnoreCase(string));
		driver.close();
	}
	@Then("^I should see an error message \"([^\"]*)\"$")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
		Assert.assertEquals(expectedErrorMessage, landingpage.getErrorMassage());
		driver.close();
    }
}
