package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver webDriver;

	// PageFactory Pattern
	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(css = ".action__submit")
	private WebElement submit;

	@FindBy(css = ".ta-item:nth-of-type(1)")
	private WebElement selectCountry;

	private By resultsBy = By.cssSelector(".ta-results");

	public CheckoutPage(WebDriver webDriver) {

		// Instance initialisation
		super(webDriver);
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void selectCountry(String countryName) throws InterruptedException {
		Actions action = new Actions(webDriver);
		action.sendKeys(country, countryName).build().perform();

		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(webDriver);
	}

}
