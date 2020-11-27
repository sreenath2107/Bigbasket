package com.bigbasket.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BigbasketPage {

	WebDriver ldriver;
	
	public BigbasketPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//input[@id='input']")
	@CacheLookup
	WebElement searchBar;
	
	@FindBy(xpath="//button[@qa='searchBtn']")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(xpath="(//input[@ng-model='vm.brandSearch'])[1]")
	@CacheLookup
	WebElement searchByBrand;
	
	@FindBy(xpath="(//span[text()='Cambridge Tea Party'])[1]")
	@CacheLookup
	WebElement firstSelectedBrand;
	
	@FindBy(xpath="(//span[text()='Udyan Tea'])[1]")
	@CacheLookup
	WebElement lastSelectedBrand;
	
	@FindBy(xpath="//input[@id='snowplow_screen_view_totalcount']")
	@CacheLookup
	WebElement totalNumberofItemsScreenviewTotalCount;
	
	@FindBy(xpath="//a[text()='Green Tea - Rose Marvel']/parent::div/following-sibling::div/following-sibling::div//span[text()='400']")
	@CacheLookup
	WebElement priceFirstProduct;
	
	@FindBy(xpath="(//a[text()='Green Tea - Rose Marvel']/parent::div/following-sibling::div/following-sibling::div//input)[1]")
	@CacheLookup
	WebElement quantityFirstProduct;
	
	@FindBy(xpath="(//a[text()='Green Tea - Rose Marvel']/parent::div/following-sibling::div/following-sibling::div//input)[1]/parent::div/parent::div/parent::div//button")
	@CacheLookup
	WebElement addButtonFirstProduct;
	
	@FindBy(xpath="//span[text()='My Basket']")
	@CacheLookup
	WebElement myBasket;
	
	@FindBy(xpath="//a[text()='Udyan Tea Green Tea - Rose Marvel 50 g ']")
	@CacheLookup
	WebElement productInMyBasket;
	
	@FindBy(xpath="//div[text()='2 x 400.00']")
	@CacheLookup
	WebElement priceInMyBasketFor2Items;
	
	@FindBy(xpath="//span[text()='800.00']")
	@CacheLookup
	WebElement priceInMyBasket;
	
	
	public void clickSearchByText(String itemCategory)
	{	
		searchBar.clear();
		searchBar.sendKeys(itemCategory);
	}

	public void clickSearchIcon()
	{
		searchButton.click();
	}	
	
	public void clickSearchByBrandFilter(String item)
	{
		searchByBrand.sendKeys(item);
	}
	public void clickFirstSelectedItem()
	{
		firstSelectedBrand.click();
	}
	public void clickLastSelectedItem()
	{
		lastSelectedBrand.click();
	}	
	
	public String verifyTotalitemsinView()
	{
		 String totalItems = totalNumberofItemsScreenviewTotalCount.getText();
		 return totalItems;
	}	
	
	public String verifyPriceOfFirstProduct()
	{
		 String priceFirstproduct = priceFirstProduct.getText();
		 return priceFirstproduct;
	}
	
	public void clickChangeQuantityFirstProduct(String quantity)
	{
		quantityFirstProduct.clear();
		quantityFirstProduct.sendKeys(quantity);
	}
	public void clickAddButtonFirstProduct()
	{
		addButtonFirstProduct.click();
	}
	
	public void clickMyBasket()
	{
		myBasket.click();
	}
	
	public String verifyPriceInMyBasket()
	{
		 String price = priceInMyBasket.getAttribute("innerHTML");
		 System.out.println("Price:"+price);
		 return price;
	}	
	
	public String verifyProductInMyBasket()
	{
		 String product = productInMyBasket.getAttribute("innerHTML");
		 System.out.println("Product:"+product);
		 return product;
	}	
	
	public String verifyPriceInMyBasketFor2Items()
	{
		 String price2Items = priceInMyBasketFor2Items.getAttribute("innerHTML");
		 System.out.println("Pricefor2items:"+price2Items);
		 return price2Items;
	}
	
	
}
