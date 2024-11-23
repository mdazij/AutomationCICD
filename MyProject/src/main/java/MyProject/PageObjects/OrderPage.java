package MyProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyProject.AbstractComponents.AbstarctComponent;

public class OrderPage extends AbstarctComponent {
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "tr td:nth-child(3)")
	List<WebElement> productlist;
	
	public Boolean verifyOrderDisplay(String ProductName) {
		Boolean match = productlist.stream().anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;
	}

}
