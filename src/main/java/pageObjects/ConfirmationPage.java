package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	WebDriver webDriver;

	// PageFactory Pattern
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	public ConfirmationPage(WebDriver webDriver) {

		// Instance initialisation
		super(webDriver);
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}

}
