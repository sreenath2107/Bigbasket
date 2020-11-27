package com.bigbasket.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.bigbasket.pageobjects.BigbasketPage;

public class TC_Bigbasket extends BaseClass
{
	private String searchText = "Green Tea";
	private String item = "Tea";
	private String quantity = "2";
									   
	private String productInBasket = "Udyan Tea Green Tea - Rose Marvel 50 g ";
	private String priceInBasket = "800.00";
	private String priceInBasketFor2Items = "2 x 400.00";
	@Test
	public void loginTest() throws Exception
	{
			
		logger.info("URL is opened");
		
		BigbasketPage bbp=new BigbasketPage(driver);
		bbp.clickSearchByText(searchText);
		logger.info("Entered Green Tea");
		bbp.clickSearchIcon();		
		Thread.sleep(3000);		
		bbp.clickSearchByBrandFilter(item);		
		bbp.clickFirstSelectedItem();
		logger.info("Selected First Item");
		Thread.sleep(2000);
		bbp.clickLastSelectedItem();		
		Thread.sleep(1000);
		logger.info("Selected Last Item");
		if (bbp.verifyTotalitemsinView().equals(8))
		{
			Assert.assertTrue(true);
			logger.info("Total number of items displayed Verified");
			
		}
		Thread.sleep(3000);
		if (bbp.verifyPriceOfFirstProduct().equals(400))
		{
			Assert.assertTrue(true);
			logger.info("Price of First Product Verified");
			
		}
		//Thread.sleep(3000);
		bbp.clickChangeQuantityFirstProduct(quantity);
		logger.info("Select 2 quantity of First item");
		Thread.sleep(1000);
		bbp.clickAddButtonFirstProduct();
		//Thread.sleep(1000);
		logger.info("Click on Add to basket");
		WebElement we = driver.findElement(By.xpath("//span[text()='My Basket']"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", we);
		
		logger.info("Click on My basket");		
		Thread.sleep(2000);
		//System.out.println("Product Name in Basket is Right One?: "+bbp.verifyProductInMyBasket());
		//System.out.println("Product Name in Basket is Right One?: "+productInBasket);
		if (bbp.verifyProductInMyBasket().equals(productInBasket))
		{
			Assert.assertTrue(true);
			logger.info("Product in the basket is Verified");
		}
		else
		{
			captureScreen(driver,"BigbasketTest");
			Assert.assertTrue(false);
			logger.info("BigbasketTest: Product verification in MyBasket failed");
		}
		if (bbp.verifyPriceInMyBasket().equals(priceInBasket))
		{
			Assert.assertTrue(true);
			logger.info("Price in the basket is Verified");
		}
		else
		{
			captureScreen(driver,"BigbasketTest");
			Assert.assertTrue(false);
			logger.info("BigbasketTest: Price verification in MyBasket failed");
		}
		
		if (bbp.verifyPriceInMyBasketFor2Items().equals(priceInBasketFor2Items))
		{
			Assert.assertTrue(true);
			logger.info("Price Verification for 2 items is Verified");
			
		}
		else
		{
			captureScreen(driver,"BigbasketTest");
			Assert.assertTrue(false);
			logger.info("BigbasketTest: Price verification for 2 items in MyBasket failed");
		}
	}
	
}
