package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class ShoppingSummaryPage extends PredefinedActions {
	
	public ArrayList<String> getProductDetailsOnSummaryPage() {
		ArrayList<String>actualProductDetails = new ArrayList <String>();
		WebDriverWait wait = new WebDriverWait(driver,30);
		String productName =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_description .product-name>a"))).getText();
		String unitPrice =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_unit>.price>span"))).getText();
		String actaulUnitPrice = unitPrice.substring(1);
		String quantity = driver.findElement(By.cssSelector(".cart_quantity.text-center>input:nth-child(1)")).getAttribute("Value");
		String total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_total>.price"))).getText();
		String actualTotal = total.substring(1);		
		String colourandsize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_description small>a"))).getText();
		String[] colourandsizeArray= colourandsize.split(":");
		/*for(int i =0 ; i<colourandsizeArray.length; i++) {
			System.out.println(colourandsizeArray[i]);
		}*/
		String []ColourArray = colourandsizeArray[1].substring(1).split(",");
		String Colour = ColourArray[0];
		String size= colourandsizeArray[2].substring(1);
		actualProductDetails.add(productName);
		actualProductDetails.add(Colour);
		actualProductDetails.add(size);
		actualProductDetails.add(quantity);
		actualProductDetails.add(actualTotal);
		return actualProductDetails;
	}
	
	public AddressPage proceedToCheckout() {
		WebElement checkoutElement = driver.findElement(By.cssSelector(".cart_navigation.clearfix>a>span"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);
		return new AddressPage();		
	}

}
