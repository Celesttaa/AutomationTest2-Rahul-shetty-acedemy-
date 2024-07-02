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
import Rahulshettyacedemy.pageobjects.ProductCatalog;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest { 

	
@Test(groups= {"ErrorHandling"})
public void loginErrorValidation() throws IOException, InterruptedException
{
		String productName= "ZARA COAT 3";
		ProductCatalog productcatalog =landingPage.loginApplication("celesttaabhardwaj@gmail.com","Rahuhetty@11");
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
	
	}


@Test
public void productErrorValidation() throws IOException, InterruptedException
{
	String productName= "ZARA COAT 3";
    LandingPage landingPage= launchApplication();
	ProductCatalog productcatalog =landingPage.loginApplication("celesttaabhardwaj@gmail.com","Rahulshetty@11");
	
	List<WebElement> products =productcatalog.getProductList();
	productcatalog.addProductToCart(productName);

	CartPage cartPage = productcatalog.goToCartPage();

	Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	
}
}
