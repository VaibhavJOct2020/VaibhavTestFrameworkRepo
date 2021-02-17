package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import vaibhav.framework.base.PredefinedActions;

public class AddressPage extends PredefinedActions {
	
	public ShippingPage proceedToCheckoutonAddressPage() {
		WebElement checkoutElement = driver.findElement(By.cssSelector(".cart_navigation.clearfix .button.btn.btn-default.button-medium>span"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);
		return new ShippingPage();		
	}
	
	public ArrayList<String> verifyDeliveryAddress() {
		ArrayList<String>deliveryAddressList = new ArrayList<String>();
		String company = driver.findElement(By.cssSelector("#address_delivery>li:nth-child(3)")).getText();
		String address = driver.findElement(By.cssSelector("#address_delivery>li:nth-child(4)")).getText();
		String phone = driver.findElement(By.cssSelector("#address_delivery>li:nth-child(7)")).getText();
		String mobile = driver.findElement(By.cssSelector("#address_delivery>li:nth-child(8)")).getText();
		deliveryAddressList.add(company);
		deliveryAddressList.add(address);
		deliveryAddressList.add(phone);
		deliveryAddressList.add(mobile);
		return deliveryAddressList;
	}
	
	public ArrayList<String> verifyBillingAddress() {
		ArrayList<String>billingAddressList = new ArrayList<String>();
		String company = driver.findElement(By.cssSelector("#address_invoice>li:nth-child(3)")).getText();
		String address = driver.findElement(By.cssSelector("#address_invoice>li:nth-child(4)")).getText();
		String phone = driver.findElement(By.cssSelector("#address_invoice>li:nth-child(7)")).getText();
		String mobile = driver.findElement(By.cssSelector("#address_invoice>li:nth-child(8)")).getText();
		billingAddressList.add(company);
		billingAddressList.add(address);
		billingAddressList.add(phone);
		billingAddressList.add(mobile);
		return billingAddressList;
	}
	
}
