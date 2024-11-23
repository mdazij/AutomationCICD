package MyProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css = ".cartSection h3")
	List <WebElement> cartProducts;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutele;
	
	public Boolean verifyProductDisplay (String ProductName) {
		Boolean match = cartProducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutele.click();
//		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return new CheckoutPage(driver);
		
	}

}
