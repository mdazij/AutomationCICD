package MyProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.PageObjects.CartPage;
import MyProject.PageObjects.ProductCatalogue;
import MyProject.testComponent.BaseTest;
import MyProject.testComponent.Retry;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups = {"ErrorHandeling"}, retryAnalyzer = Retry.class)
	public void loginErrorValidation() {
		
		
		landingpage.loginApplication("cybersonet08@gmail.com", "Sk@876844");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMassage());
	}
	@Test
	public void productErrorValidation() throws InterruptedException {
		String ProductName = "ADIDAS ORIGINAL";
		ProductCatalogue productcatalogue = landingpage.loginApplication("cybersonet07@gmail.com", "Sk@876844");
		productcatalogue.getProductsList();
		productcatalogue.addProductToCart(ProductName);
		CartPage cartpage = productcatalogue.goToCart();
		Boolean match = cartpage.verifyProductDisplay(ProductName);
		Assert.assertTrue(match,"The product is not displayed in the cart.");
	}

}
