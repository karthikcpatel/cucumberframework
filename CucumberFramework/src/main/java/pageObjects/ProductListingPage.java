package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//li[@id='menu-item-72']//a") 
	private WebElement btn_ProductCategory;
	
	public void clickOn_ProductCategory() {
		btn_ProductCategory.click();
	}
	
	@FindBy(how = How.XPATH, using = "//form[@name='product_32']//input[@value='Add To Cart']") 
	private WebElement btn_AddToCart;
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
}