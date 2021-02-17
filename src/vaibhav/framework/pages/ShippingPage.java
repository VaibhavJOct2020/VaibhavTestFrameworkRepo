package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class ShippingPage extends PredefinedActions {
	
	public void acceptTermsOfService() {
		WebElement terms = driver.findElement(By.id("cgv"));
		terms.click();				
	}
	
	public PayementPage proceedToCheckoutonShippingPage() {		
		WebElement checkoutElement = driver.findElement(By.cssSelector(".cart_navigation.clearfix .button.btn.btn-default.button-medium>span"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);
		return new PayementPage();
		
	}

}
