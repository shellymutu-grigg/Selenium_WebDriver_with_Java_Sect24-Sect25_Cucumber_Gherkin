package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver webDriver;

	// PageFactory Pattern
	@FindBy(css = ".totalRow button")
	WebElement checkout;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;

	public CartPage(WebDriver webDriver) {

		// Instance initialisation
		super(webDriver);
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public Boolean verifyProductDisplay(String productName) {
		boolean match = productTitles.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckoutPage goToCheckOut() {
		checkout.click();
		return new CheckoutPage(webDriver);
	}
}
