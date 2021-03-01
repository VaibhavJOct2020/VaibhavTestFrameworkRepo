package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class ShippingPage extends PredefinedActions {
	
	private PropertyFileReader propertyFileReader;
	private static ShippingPage shippingPage;
	
	private ShippingPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.SHIPPING_PAGE_PROPERTIES);		
	}
	
	public static ShippingPage getInstance() {
		if(shippingPage==null) {
			shippingPage = new ShippingPage();
		}
		return shippingPage;		
	}	
	public void acceptTermsOfService() {
		//WebElement termsElement = driver.findElement(By.id("cgv"));
		//termsElement.click();
		//clickOnElement(propertyFileReader.getValue("terms"),true);
		WebElement termsElement = getElement(propertyFileReader.getValue("terms"),false);
		checkOnElement(termsElement);		
	}	
	public PayementPage proceedToCheckoutonShippingPage() {		
		//WebElement checkoutElement = driver.findElement(By.cssSelector(propertyFileReader.getValue("checkout")));
		/*WebElement checkoutElement = getElement(propertyFileReader.getValue("checkout"), true);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);*/
		clickOnElement(propertyFileReader.getValue("checkout"),true);
		return PayementPage.getInstance();		
	}
}
