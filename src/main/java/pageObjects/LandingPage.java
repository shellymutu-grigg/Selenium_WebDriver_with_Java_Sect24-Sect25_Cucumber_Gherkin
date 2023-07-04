package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver webDriver;

	// PageFactory Pattern
	@FindBy(id = "userEmail")
	private WebElement userEmail;

	@FindBy(id = "userPassword")
	private WebElement userPassword;

	@FindBy(id = "login")
	private WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;

	public LandingPage(WebDriver webDriver) {
		super(webDriver);
		// Instance initialisation
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(webDriver);
		return productCatalogue;
	}

	public String getErrorMessage() throws InterruptedException {

		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void navigate() {
		webDriver.get("https://rahulshettyacademy.com/client/");
	}

}
