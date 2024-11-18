package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {

	@FindBy (xpath = "//div[@class='cart_item']")private List<WebElement> cartItem;
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> productsName;
	
	public SwagLabCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getCartItem() {
		return cartItem.size();
	}
	
	public String getProductName(int index) {
		return productsName.get(index).getText();
	}
	
	


}
