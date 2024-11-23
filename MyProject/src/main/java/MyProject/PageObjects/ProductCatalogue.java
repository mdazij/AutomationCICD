package MyProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyProject.AbstractComponents.AbstarctComponent;

public class ProductCatalogue extends AbstarctComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css = ".mb-3")
	List <WebElement> products;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMassage = By.id("toast-container");
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);	
		return products;
	}
	
	public WebElement getProductByName(String ProductName) {
		WebElement prod = getProductsList().stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException {
		WebElement prod =  getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMassage);
		waitForElementToDisappear(spinner);
	}

}
