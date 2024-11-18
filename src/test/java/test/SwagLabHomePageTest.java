package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)
public class SwagLabHomePageTest extends BaseTest {
	
	@BeforeMethod
	public void LaunchApplication() {
		driver =Browser.openBrowser();
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void VerfiySortFeatureForZtoA() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		String[] names =swagLabHomePage.getAllProductName();
		swagLabHomePage.sortProducts("Name (Z to A)",driver);
		String[] sortedNames =swagLabHomePage.getAllProductName();
		Assert.assertEquals(names[0],sortedNames[5]);
		Assert.assertEquals(names[1],sortedNames[4]);
		Assert.assertEquals(names[2],sortedNames[3]);
		Assert.assertEquals(names[3],sortedNames[2]);
		Assert.assertEquals(names[4],sortedNames[1]);
		Assert.assertEquals(names[5],sortedNames[0]);
		
	}
	
	@Test
	public void VerfiySortFeatureForAtoZ() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		swagLabHomePage.sortProducts("Name (Z to A)", driver);
		String[] names =swagLabHomePage.getAllProductName();
		swagLabHomePage.sortProducts("Name (A to Z)", driver);
		String[] sortedNames =swagLabHomePage.getAllProductName();
		Assert.assertEquals(names[0],sortedNames[5]);
		Assert.assertEquals(names[1],sortedNames[4]);
		Assert.assertEquals(names[2],sortedNames[3]);
		Assert.assertEquals(names[3],sortedNames[2]);
		Assert.assertEquals(names[4],sortedNames[1]);
		Assert.assertEquals(names[5],sortedNames[0]);
		
	}
	
	@Test
	public void VerfiySortFeatureForPriceLowToHigh() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		swagLabHomePage.sortProducts("Price (low to high)", driver);
		double [] price =swagLabHomePage.getAllProductsPrice();
		Assert.assertTrue((price[0]<=price[1] && price[1]<= price[2] && price[2]<=price[3] && price[3]<=price[4] && price[4]<=price[5] ));
	}
	
	@Test
	public void VerfiySortFeatureForPriceHighToLow() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		swagLabHomePage.sortProducts("Price (high to low)", driver);
		double [] price =swagLabHomePage.getAllProductsPrice();
		Assert.assertTrue((price[0]>=price[1] && price[1]>= price[2] && price[2]>=price[3] && price[3]>=price[4] && price[4]>=price[5] ));
	}
}
