package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class CartTest extends BaseTest{
	
	@BeforeMethod
	public void LaunchApplication() {
		driver =Browser.openBrowser();
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void verifyIfUserIsAbleTOAddProductToCart() {
		test =reports.createTest("verifyIfUserIsAbleTOAddProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddToCart(0);
		String productName =swagLabHomePage.getProductName(0);
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		Assert.assertEquals(swagLabCartPage.getCartItem(), 1);
		Assert.assertEquals(swagLabCartPage.getProductName(0), productName);
	}
	
	@Test
	public void addProductToCart() {
		test =reports.createTest("addProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddToCart(0);
		swagLabHomePage.clickOnAddToCart(0);
		swagLabHomePage.clickOnAddToCart(0);
		swagLabHomePage.clickOnAddToCart(0);
		
	}
}
