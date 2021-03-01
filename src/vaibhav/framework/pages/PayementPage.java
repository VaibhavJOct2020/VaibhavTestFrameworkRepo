package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class PayementPage extends PredefinedActions{
	private PropertyFileReader propertyFileReader;
	private static PayementPage payementPage;
	
	private PayementPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.PAYEMENT_PAGE_PROPERTIES);		
	}
	
	public static PayementPage getInstance() {
		if(payementPage==null) {
			payementPage= new PayementPage();
		}
		return payementPage;		
	}
	
	
	public void payByWire() {		
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("paybywire")))).click();*/
		/*WebElement payByWireElement = getElement(propertyFileReader.getValue("paybywire"), true);
		payByWireElement.click();*/
		clickOnElement(propertyFileReader.getValue("paybywire"), true);
	}
	
	public void confirmTheOrder() {
		//WebElement confirmOrderElement = driver.findElement(By.cssSelector(propertyFileReader.getValue("confirmtheorder")));
		/*WebElement confirmOrderElement = getElement(propertyFileReader.getValue("confirmtheorder"), true);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", confirmOrderElement);*/
		clickOnElement(propertyFileReader.getValue("confirmtheorder"), true);
	}
	

}
