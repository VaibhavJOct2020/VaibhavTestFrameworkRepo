package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class AddressPage extends PredefinedActions {
	
	private PropertyFileReader propertyFileReader ; 
	private static AddressPage addressPage;
	
	private AddressPage() {
		propertyFileReader = new PropertyFileReader(ConfigFilePath.ADDRESS_PAGE_PROPERTIES);
	}
	
	public static AddressPage getInstance() {
		if(addressPage==null) {
			addressPage=new AddressPage();			
		}		
		return addressPage;		
	}
	
	public ShippingPage proceedToCheckoutonAddressPage() {
		//WebElement checkoutElement = driver.findElement(By.cssSelector(propertyFileReader.getValue("checkout")));
		WebElement checkoutElement=getElement(propertyFileReader.getValue("checkout"), true);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);
		return ShippingPage.getInstance();		
	}
	
	public ArrayList<String> verifyDeliveryAddress() {
		ArrayList<String>deliveryAddressList = new ArrayList<String>();
	/*	String company = driver.findElement(By.cssSelector(propertyFileReader.getValue("company"))).getText();
		String address = driver.findElement(By.cssSelector(propertyFileReader.getValue("address"))).getText();
		String phone = driver.findElement(By.cssSelector(propertyFileReader.getValue("phone"))).getText();
		String mobile = driver.findElement(By.cssSelector(propertyFileReader.getValue("mobile"))).getText();*/
	/*	String company = getElement(propertyFileReader.getValue("company"), true).getText();
		String address = getElement(propertyFileReader.getValue("address"), true).getText();
		String phone = getElement(propertyFileReader.getValue("phone"), false).getText();
		String mobile = getElement(propertyFileReader.getValue("mobile"),false).getText();*/
		String company = getElementText(propertyFileReader.getValue("company"), true);
		String address = getElementText(propertyFileReader.getValue("address"), true);
		String phone = getElementText(propertyFileReader.getValue("phone"), false);
		String mobile = getElementText(propertyFileReader.getValue("mobile"),false);
		deliveryAddressList.add(company);
		deliveryAddressList.add(address);
		deliveryAddressList.add(phone);
		deliveryAddressList.add(mobile);
		return deliveryAddressList;
	}
	
	public ArrayList<String> verifyBillingAddress() {
		ArrayList<String>billingAddressList = new ArrayList<String>();
		/*String company = driver.findElement(By.cssSelector(propertyFileReader.getValue("Company"))).getText();
		String address = driver.findElement(By.cssSelector(propertyFileReader.getValue("Address"))).getText();
		String phone = driver.findElement(By.cssSelector(propertyFileReader.getValue("Phone"))).getText();
		String mobile = driver.findElement(By.cssSelector(propertyFileReader.getValue("Mobile"))).getText();*/
		String company = getElementText(propertyFileReader.getValue("Company"),true);
		String address = getElementText(propertyFileReader.getValue("Address"),true);
		String phone = getElementText(propertyFileReader.getValue("Phone"), false);
		String mobile = getElementText(propertyFileReader.getValue("Mobile"),false);
		billingAddressList.add(company);
		billingAddressList.add(address);
		billingAddressList.add(phone);
		billingAddressList.add(mobile);
		return billingAddressList;
	}
	
}
