package Rahulshettyacedemy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

@FindBy(css = "[placeholder='Select Country']")
WebElement country;

@FindBy(css= ".action__submit ")
WebElement submit; 

@FindBy(xpath ="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]")
WebElement selectCountry;

By results= By.cssSelector(".ta-results");

public void selectCountry(String countryName)
{
	Actions a= new Actions(driver);
	a.sendKeys(country,countryName).build().perform();
	waitForElementToAppear(By.cssSelector(".ta-results"));
    selectCountry.click();	
}

public ConfirmationPage submitOrder()
{
	submit.click();
	return new ConfirmationPage(driver);
}
} 












