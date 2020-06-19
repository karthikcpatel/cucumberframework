package stepDefinitions;

import java.util.concurrent.TimeUnit;

import managers.PageObjectManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import cucumber.api.java.en.Given;
import dataProviders.ConfigFileReader;

public class Tests {
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;

	@Given("^I open demo website$")
	public void i_open_demo_website() throws Throwable {
		configFileReader= new ConfigFileReader();
		//System.setProperty("webdriver.chrome.driver","C:\\eclipse\\drivers\\chromedriver_2.34.exe");
		System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(),TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();
	}
	
	@Given("^I click on product category and add a product to cart$")
	public void i_click_on_product_category_and_add_a_product_to_cart() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.clickOn_ProductCategory();
		Thread.sleep(500);
		productListingPage.clickOn_AddToCart();	
	}
	
	@Given("^I click checkout$")
	public void i_click_checkout() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Checkout();
	}

	@Given("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	}
}