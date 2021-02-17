package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class PayementPage extends PredefinedActions{
	
	public void payByWire() {		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Pay by bank wire ')]"))).click();
	}
	
	public void confirmTheOrder() {
		WebElement confirmOrderElement = driver.findElement(By.cssSelector(".cart_navigation.clearfix .button.btn.btn-default.button-medium>span"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", confirmOrderElement);
	}
	

}
