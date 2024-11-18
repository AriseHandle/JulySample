package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	
	
	
	@BeforeMethod
	public void launchApplication() {
		driver =Browser.openBrowser();
	}
	
	@Test
	public void verifyIfUserIsAbleToLoginWithValidCredentials() {
		test =reports.createTest("verifyIfUserIsAbleToLoginWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html" );
		//Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}
	
	@Test
	public void verifyIfWarningMesaageIsDisplayedForLockedUser() {
		test = reports.createTest("verifyIfWarningMesaageIsDisplayedForLockedUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertTrue(swagLabLoginPage.isWarningLabelDisplayed());
		Assert.assertEquals(swagLabLoginPage.getWarningMessage(),"Epic sadface: Sorry, this user has been locked out.");
	}
	
	
	
}
