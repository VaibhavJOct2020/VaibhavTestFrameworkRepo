package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.pojo.ProductDetailsPojo;

public class ProductDetailsPage extends PredefinedActions {
	WebElement unitPriceElement;
	WebElement quantityElement;
	WebElement colourElement;
	
	
	ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
	WebDriverWait wait;
	
	public ArrayList <String> captureDetails() {		
		ArrayList <String> expectedProductDetailsList = new ArrayList();
					
		setProductTitle();			
		expectedProductDetailsList.add(productDetailsPojo.getProductName());
		expectedProductDetailsList.add(productDetailsPojo.getColour());
		expectedProductDetailsList.add(productDetailsPojo.getSize());
		expectedProductDetailsList.add(productDetailsPojo.getQuantity());
		expectedProductDetailsList.add(productDetailsPojo.getProductPrice());
		
		return expectedProductDetailsList;
	}
	
	public void setProductTitle() {
		wait = new WebDriverWait(driver,30);
		String productName= driver.findElement(By.xpath("//*[contains(@class,'pb-center-column')]/h1")).getText();
		productDetailsPojo.setProductName(productName);//setting product name so that when we do getproduct name it will fetch it's value
		System.out.println(productName);		
	}
	
	public void setQuantity(String numberOfQuantity) {
		wait = new WebDriverWait(driver,30);
		quantityElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quantity_wanted_p>input")));
		quantityElement.clear();
		quantityElement.sendKeys(numberOfQuantity);	
		productDetailsPojo.setQuantity(numberOfQuantity);
		unitPriceElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("our_price_display")));
		String unitPrice = unitPriceElement.getText();
		productDetailsPojo.setProductPrice(unitPrice);
	}
	
	public void setSize(String size) {
		WebElement selectWebElement =driver.findElement(By.tagName("select"));
		Select select =new Select(selectWebElement);
		select.selectByVisibleText(size);
		productDetailsPojo.setSize(size);
	}
	
	public void setColour(String Colour) {
		wait = new WebDriverWait(driver,30);
		if (Colour.equals("Orange")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name,'Orange')]"))).click();
			productDetailsPojo.setColour(Colour);
		}
		else if (Colour.equals("Blue")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name,'Blue')]"))).click();
			productDetailsPojo.setColour(Colour);
		}
	}
	
	public void clickAddTocart() {
		driver.findElement(By.cssSelector("#add_to_cart>button")).click();		
	}
	
	public ArrayList<String> verifyProductDetails() {
		wait = new WebDriverWait(driver,30);
		ArrayList <String> actualProductDetailsList = new ArrayList();		
		String productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_title"))).getText();
		String productAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_attributes"))).getText();
		String [] productAttributeArray=productAttribute.split(",");
		String colour = productAttributeArray[0];
		System.out.println(colour);
		String size = productAttributeArray[1];	
		String actualSize=size.substring(1);
		System.out.println(actualSize);
		String actualQuantity= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_quantity"))).getText();
		String productPricewithdollar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_price"))).getText();
		String productPrice = productPricewithdollar.substring(1);
		actualProductDetailsList.add(productTitle);
		actualProductDetailsList.add(colour);
		actualProductDetailsList.add(actualSize);
		actualProductDetailsList.add(actualQuantity);
		actualProductDetailsList.add(productPrice);
		return actualProductDetailsList;		
	}
	
	public ShoppingSummaryPage proceedToCheckout() {
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		return new ShoppingSummaryPage();		
	}
}
