package testComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	// Global variables
	String productNameString = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {

		// Login to site
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		// Generate list of products on page
		List<WebElement> products = productCatalogue.getProductList();

		// Find product and add to cart
		productCatalogue.addProductToCart(input.get("productName"));

		// Navigate to cart
		CartPage cartPage = productCatalogue.goToCartPage();

		// Manage cart page actions
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();

		// Manage checkout page actions
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		String confirmMessageString = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessageString.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrderTest" })
	public void orderHistoryTest() {
		// Login to site
		ProductCatalogue productCatalogue = landingPage.loginApplication("shellymutugrigg@gmail.com",
				"gazxHSwK$oBbd*c43t4S");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrdersDisplay(productNameString));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shellymutugrigg@gmail.com");
//		map1.put("password", "gazxHSwK$oBbd*c43t4S");
//		map1.put("productName", "ZARA COAT 3");
//
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("email", "shellymutugrigg2@gmail.com");
//		map2.put("password", "gazxHSwK$oBbd*c43t4S2");
//		map2.put("productName", "ADIDAS ORIGINAL");

		List<HashMap<String, String>> dataHashMaps = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//PurchaseOrder.json");
		return new Object[][] { { dataHashMaps.get(0) }, { dataHashMaps.get(1) } };

	}

}
