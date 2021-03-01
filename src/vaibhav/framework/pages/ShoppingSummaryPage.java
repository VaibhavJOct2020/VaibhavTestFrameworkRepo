package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class ShoppingSummaryPage extends PredefinedActions {
	
	private PropertyFileReader propertyFileReader;
	private static ShoppingSummaryPage shoppingSummaryPage;
	
	private ShoppingSummaryPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.SHOPPINGSUMMARY_PAGE_PROPERTIES);		
	}
	
	public static ShoppingSummaryPage getInstance() {
		if(shoppingSummaryPage==null) {
			shoppingSummaryPage = new ShoppingSummaryPage();
		}
		return shoppingSummaryPage;
	}
	
	public ArrayList<String> getProductDetailsOnSummaryPage() {
		ArrayList<String>actualProductDetails = new ArrayList <String>();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//String productName =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("productName")))).getText();
		WebElement productNameElement = getElement(propertyFileReader.getValue("productName"), true);
		String productName =getElementText(productNameElement);
		//String unitPrice =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("unitPrice")))).getText();
		WebElement unitPriceElement = getElement(propertyFileReader.getValue("unitPrice"), true);
		String unitPrice =getElementText(unitPriceElement);
		// productNameElement.getText();
		String actaulUnitPrice = unitPrice.substring(1);
		//String quantity = driver.findElement(By.cssSelector(propertyFileReader.getValue("quantity"))).getAttribute("Value");
		WebElement quantityElement = getElement(propertyFileReader.getValue("quantity"), true);
		String quantity = quantityElement.getAttribute("Value");
		//String total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("total")))).getText();
		/*WebElement totalElement = getElement(propertyFileReader.getValue("total"), true);
		String total = totalElement.getText();*/
		String total = getElementText(propertyFileReader.getValue("total"), true);
		String actualTotal = total.substring(1);		
		//String colourandsize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("colourandsize")))).getText();
		/*WebElement colourandsizeElement = getElement(propertyFileReader.getValue("colourandsize"), true);
		String colourandsize = colourandsizeElement.getText();*/
		String colourandsize = getElementText(propertyFileReader.getValue("colourandsize"), true);
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
		//WebElement checkoutElement = driver.findElement(By.cssSelector(propertyFileReader.getValue("checkout")));
		/*WebElement checkoutElement = getElement(propertyFileReader.getValue("checkout"), true);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", checkoutElement);*/
		clickOnElement(propertyFileReader.getValue("checkout"), true);
		return AddressPage.getInstance();		
	}

}
