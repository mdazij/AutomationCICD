package MyProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyProject.AbstractComponents.AbstarctComponent;

public class LandingPage extends AbstarctComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//Initilization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id ="userPassword")
	WebElement upassword;
	
	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMassage;
	
	public ProductCatalogue loginApplication (String email, String password) {
		userEmail.sendKeys(email);
		upassword.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue
		;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMassage() {
		waitForWebElementToAppear(errorMassage);
		return errorMassage.getText();
	}

}
