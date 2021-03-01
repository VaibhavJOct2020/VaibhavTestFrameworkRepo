package vaibhav.framework.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.pojo.ProductDetailsPojo;
import vaibhav.framework.utils.PropertyFileReader;

public class ProductDetailsPage extends PredefinedActions {
	private WebElement unitPriceElement;
	private WebElement quantityElement;
	private WebElement colourElement;		
	private WebDriverWait wait;	
	private PropertyFileReader propertyFileReader;
	private ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
	private static ProductDetailsPage productDetailsPage;
	
	private ProductDetailsPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.PROODUCTDETAILS_PAGE_PROPERTIES);		
	}
	
	public static ProductDetailsPage getInstance() {
		if(productDetailsPage==null) {
			productDetailsPage=new ProductDetailsPage();			
		}
		return productDetailsPage;
	}
	
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
		/*wait = new WebDriverWait(driver,30);
		String productName= driver.findElement(By.xpath(propertyFileReader.getValue("productname"))).getText();*/
		/*WebElement productNameElement = getElement(propertyFileReader.getValue("productname"), true);
		String productName=productNameElement.getText();*/
		String productName=getElementText(propertyFileReader.getValue("productname"), true);
		productDetailsPojo.setProductName(productName);//setting product name so that when we do getproduct name it will fetch it's value
		System.out.println(productName);		
	}
	
	public void setQuantity(String numberOfQuantity) {
		/*wait = new WebDriverWait(driver,30);
		quantityElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("quantity"))));*/
		/*quantityElement=getElement(propertyFileReader.getValue("quantity"), true);
		quantityElement.clear();
		quantityElement.sendKeys(numberOfQuantity);	*/
		enterText(propertyFileReader.getValue("quantity"), true, numberOfQuantity);
		productDetailsPojo.setQuantity(numberOfQuantity);
		//unitPriceElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("unitprice"))));
		/*unitPriceElement=getElement(propertyFileReader.getValue("unitprice"), true);
		String unitPrice = unitPriceElement.getText();*/
		String unitPrice =  getElementText(propertyFileReader.getValue("unitprice"), true);
		productDetailsPojo.setProductPrice(unitPrice);
	}
	
	public void setSize(String size) {
		WebElement selectWebElement =driver.findElement(By.tagName(propertyFileReader.getValue("Select")));
		//WebElement selectWebElement = getElement(propertyFileReader.getValue("Select"), true);
		Select select =new Select(selectWebElement);
		select.selectByVisibleText(size);
		productDetailsPojo.setSize(size);
	}
	
	public void setColour(String Colour) {
		wait = new WebDriverWait(driver,30);
		if (Colour.equals("Orange")) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("orange")))).click();
			/*WebElement orangeElement = getElement(propertyFileReader.getValue("orange"), true);
			orangeElement.click();*/
			clickOnElement(propertyFileReader.getValue("orange"), true);
			productDetailsPojo.setColour(Colour);
		}
		else if (Colour.equals("Blue")) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("blue")))).click();
			/*WebElement blueElement = getElement(propertyFileReader.getValue("blue"), true);
			blueElement.click();*/
			clickOnElement(propertyFileReader.getValue("blue"), true);
			productDetailsPojo.setColour(Colour);
		}
	}
	
	public void clickAddTocart() {
		//driver.findElement(By.cssSelector(propertyFileReader.getValue("cart"))).click();	
		/*WebElement cartElement = getElement(propertyFileReader.getValue("cart"), true);
		cartElement.click();*/
		clickOnElement(propertyFileReader.getValue("cart"), true);
	}
	
	public ArrayList<String> verifyProductDetails() {
		wait = new WebDriverWait(driver,30);
		ArrayList <String> actualProductDetailsList = new ArrayList();		
		//String productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("producttitle")))).getText();
		/*WebElement productTitleElement = getElement(propertyFileReader.getValue("producttitle"), true);
		String productTitle = productTitleElement.getText();*/
		String productTitle = getElementText(propertyFileReader.getValue("producttitle"), true);
		//String productAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("productattribute")))).getText();
		/*WebElement productAttributeElement = getElement(propertyFileReader.getValue("productattribute"), true);
		String productAttribute = productAttributeElement.getText();*/
		String productAttribute = getElementText(propertyFileReader.getValue("productattribute"), true);
		String [] productAttributeArray=productAttribute.split(",");
		String colour = productAttributeArray[0];
		System.out.println(colour);
		String size = productAttributeArray[1];	
		String actualSize=size.substring(1);
		System.out.println(actualSize);
		//String actualQuantity= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("actualquantity")))).getText();
		/*WebElement actualQuantityElement = getElement(propertyFileReader.getValue("actualquantity"), true);
		String actualQuantity = actualQuantityElement.getText();*/
		String actualQuantity = getElementText(propertyFileReader.getValue("actualquantity"), true);
		//String productPricewithdollar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("productpricewithdollar")))).getText();*/
		//WebElement productPricewithdollarElement = getElement(propertyFileReader.getValue("productpricewithdollar"), true);
		//String productPricewithdollar = productPricewithdollarElement.getText();
		String productPricewithdollar =	getElementText(propertyFileReader.getValue("productpricewithdollar"), true);
		String productPrice = productPricewithdollar.substring(1);
		actualProductDetailsList.add(productTitle);
		actualProductDetailsList.add(colour);
		actualProductDetailsList.add(actualSize);
		actualProductDetailsList.add(actualQuantity);
		actualProductDetailsList.add(productPrice);
		return actualProductDetailsList;		
	}
	
	public ShoppingSummaryPage proceedToCheckout() {
		//driver.findElement(By.xpath(propertyFileReader.getValue("proceedtocheckout"))).click();
		/*WebElement shoppingSummaryElement = getElement(propertyFileReader.getValue("proceedtocheckout"), true);
		shoppingSummaryElement.click();*/
		clickOnElement(propertyFileReader.getValue("proceedtocheckout"), true);
		return ShoppingSummaryPage.getInstance();		
	}
}
