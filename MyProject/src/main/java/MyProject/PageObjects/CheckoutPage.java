package MyProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyProject.AbstractComponents.AbstarctComponent;

public class CheckoutPage extends AbstarctComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(css = "input[placeholder ='Select Country']")
	WebElement country;
	@FindBy(css = ".ta-item")
	List <WebElement> suggestions;
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrder;
	@FindBy(css = ".hero-primary")
	WebElement massage;
	
	By AppearBox = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(AppearBox);
		suggestions.stream().filter(s-> s.getText().equalsIgnoreCase(countryName)).findAny().ifPresent(WebElement::click);
	}
	
	public ConfirmationPage submitOrder() {
		placeOrder.click();
		return new ConfirmationPage(driver);
//		String confirmmsg = massage.getText();
//		Boolean ordermsg = confirmmsg.equalsIgnoreCase("Thankyou for the order.");
//		return ordermsg;
		
	}

}
