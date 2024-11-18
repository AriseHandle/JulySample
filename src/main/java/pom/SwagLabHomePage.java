package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabHomePage {

	
	@FindBy (xpath = "//div[@data-test='inventory-item-name']")private List<WebElement> productsName;
	@FindBy (xpath = "//div[@data-test='inventory-item-price']")private List<WebElement> productsPrice;
	@FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']") private List<WebElement> addToCart;
	@FindBy (xpath = "//select[@data-test='product-sort-container']") private WebElement sort;
	@FindBy (xpath = "//button[@id='react-burger-menu-btn']") private WebElement menu;
	@FindBy (xpath = "//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy	(xpath = "//a[@id='logout_sidebar_link']") private WebElement logout;
	@FindBy (xpath = "//a[@class='shopping_cart_link']")private WebElement cart;
	
	
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName(int index) {
		return productsName.get(index).getText();
	}
	
	public String[] getAllProductName() {
		String [] names = new String[productsName.size()];
		for(int i=0; i<productsName.size();i++)
		{
			names [i] =productsName.get(i).getText();
		}
		return names;
	
	}
	
	public String getProductPrice(int index) {
		return productsPrice.get(index).getText();
	}
	
	public double[] getAllProductsPrice() {
		double [] price = new double[productsName.size()];
		for(int i=0; i<productsName.size();i++)
		{
			String amount =productsPrice.get(i).getText().substring(1);
			price[i]= Double.parseDouble(amount);
		}
		return price;
	}
	
	public void clickOnAddToCart(int index) {
		addToCart.get(index).click();
	}
	
	public void sortProducts(String text,WebDriver driver) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(30000));
		wait.pollingEvery(Duration.ofMillis(1000));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(sort));
		
		
		Select select = new Select(sort);
		select.selectByVisibleText(text);
	}
	
	public void clickOnMenu() {
		menu.click();
	}
	
	public void clickOnAbout() {
		about.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnCart() {
		cart.click();
		
	}
}
