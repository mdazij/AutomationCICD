package MyProject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyProject.PageObjects.CartPage;
import MyProject.PageObjects.CheckoutPage;
import MyProject.PageObjects.ConfirmationPage;
import MyProject.PageObjects.OrderPage;
import MyProject.PageObjects.ProductCatalogue;
import MyProject.testComponent.BaseTest;

public class SubmitOrder extends BaseTest{

	
	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		productcatalogue.getProductsList();
		productcatalogue.addProductToCart(input.get("ProductName"));
		CartPage cartpage = productcatalogue.goToCart();
		Boolean match = cartpage.verifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmationmsg = confirmationpage.getConfirmationPage();
		Assert.assertTrue(confirmationmsg.equalsIgnoreCase("Thankyou for the order."));
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"},dataProvider = "getData", groups = {"orderhistory"})
	public void orderHistory(HashMap<String,String> input) {
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		OrderPage orderpage = productcatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(input.get("ProductName")));
		
	}
	
	
	
	//Extent Reports
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>>data = getJasonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\MyProject\\data\\PurchesOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
// Data with out hash map - //		return new Object[][]  {{"cybersonet07@gmail.com", "Sk@876844", "ZARA COAT 3"}, {"cybersonet08@gmail.com", "Sk@123456", "ADIDAS ORIGINAL"}};
//@hash map with out json
//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email","cybersonet07@gmail.com" );
//map.put("password", "Sk@876844");
//map.put("ProductName", "ZARA COAT 3");
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email","cybersonet08@gmail.com" );
//map1.put("password", "Sk@123456");
//map1.put("ProductName", "ADIDAS ORIGINAL");
