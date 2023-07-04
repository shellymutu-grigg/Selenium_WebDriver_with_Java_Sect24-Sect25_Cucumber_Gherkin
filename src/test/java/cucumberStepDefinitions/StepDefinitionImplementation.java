package cucumberStepDefinitions;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class StepDefinitionImplementation extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CheckoutPage checkoutPage;
	public ConfirmationPage confirmationPage;

	@Given("user has landed on the Ecommerce site page")
	public void user_has_landed_on_the_ecommerce_site_page() throws IOException {
		// Launch the application
		landingPage = launchApplication();
	}

	@Given("^user is logged in with username (.+) and password (.+)$")
	public void user_is_logged_in_with_username_and_password(String username, String password) {
		// Login to site
		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^user adds the product (.+) to cart$")
	public void user_adds_the_product_to_cart(String productName) throws InterruptedException {
		// Generate list of products on page
		List<WebElement> products = productCatalogue.getProductList();

		// Find product and add to cart
		productCatalogue.addProductToCart(productName);
	}

	@And("^user checks out (.+)$")
	public void user_checks_out_product(String productName) throws InterruptedException {
		// Navigate to cart
		CartPage cartPage = productCatalogue.goToCartPage();

		// Manage cart page actions
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkoutPage = cartPage.goToCheckOut();

		// Manage checkout page actions
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}

	@When("user submits the order")
	public void user_submits_the_order() {
		confirmationPage = checkoutPage.submitOrder();
	}

	// Can be done if text is passed in see following @Then
	// "THANKYOU FOR THE ORDER.
	// @Then("{string} is displayed on confirmation page")
	@Then("^(.+) is displayed on confirmation page$")
	public void successMessage_is_diplayed(String successMessage) {
		String confirmMessageString = confirmationPage.getConfirmationMessage();
		System.out.println(MessageFormat.format("confirmMessageString: {0}", confirmMessageString));
		System.out.println(MessageFormat.format("successMessage: {0}", successMessage));
		Assert.assertTrue(confirmMessageString.equalsIgnoreCase(successMessage));
		webDriver.close();
	}

	@Then("^\"([^\"]*)\" message is displayed")
	public void error_message_is_displayed(String errorMessage) throws InterruptedException {
		Assert.assertEquals(errorMessage, landingPage.getErrorMessage());
		webDriver.close();
	}
}
