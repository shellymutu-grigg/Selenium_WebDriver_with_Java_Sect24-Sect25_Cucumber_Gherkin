package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrdersPage;

public class AbstractComponents {

	WebDriver webDriver;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public AbstractComponents(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void waitForElementToAppear(By findBy) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		Thread.sleep(5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		Thread.sleep(5);
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	protected void waitForElementToDisappear(WebElement spinner) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));

		// Add in additional delay
		Thread.sleep(2000);
	}

	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(webDriver);
		return cartPage;
	}

	public OrdersPage goToOrdersPage() {
		orderHeader.click();
		OrdersPage ordersPage = new OrdersPage(webDriver);
		return ordersPage;
	}

}
