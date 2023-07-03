package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents {

	WebDriver webDriver;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> ordersProducts;

	public OrdersPage(WebDriver webDriver) {
		// Instance initialisation
		super(webDriver);
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public Boolean verifyOrdersDisplay(String productName) {

		boolean match = ordersProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

}
