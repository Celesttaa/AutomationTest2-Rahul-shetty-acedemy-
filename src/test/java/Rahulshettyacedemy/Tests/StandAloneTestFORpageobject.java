package Rahulshettyacedemy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Rahulshettyacedemy.pageobjects.CartPage;
import Rahulshettyacedemy.pageobjects.CheckoutPage;
import Rahulshettyacedemy.pageobjects.ConfirmationPage;
import Rahulshettyacedemy.pageobjects.LandingPage;
import Rahulshettyacedemy.pageobjects.OrderPage;
import Rahulshettyacedemy.pageobjects.ProductCatalog;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestFORpageobject extends BaseTest { 
	String productName= "ZARA COAT 3";
	
@Test
public void standaloneTest() throws IOException, InterruptedException
{
        LandingPage landingPage= launchApplication();
		ProductCatalog productcatalog =landingPage.loginApplication("celesttaabhardwaj@gmail.com","Rahulshetty@11");
		
		List<WebElement> products =productcatalog.getProductList();
		productcatalog.addProductToCart(productName);
	
		CartPage cartPage = productcatalog.goToCartPage();
	
		Boolean match =cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

@Test(dependsOnMethods= {"standaloneTest"})
public void OrderHistoryTest()
{
	//ZARA COAT 3
	ProductCatalog productCatalog = landingPage.loginApplication("celesttaabhardwaj@gmail.com", "Rahulshetty@11" );
	OrderPage orderPage = productCatalog.goToOrderPage();
	Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	
}
}

















