package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.pojo.ProductDetailsPojo;

public class ProductDetailsPage extends PredefinedActions {
	
	
	public void captureDetails() {
		//ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		String unitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("our_price_display"))).getText();
		//String unitPrice=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).getText();
		System.out.println(unitPrice);
		//productDetailsPojo.setUnitPrice(unitPrice);
		System.out.println(unitPrice);
		
		String quantity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quantity_wanted_p>input"))).getAttribute("Value");
		//productDetailsPojo.setQuantity(quantity);
		System.out.println(quantity);
		
		WebElement selectWebElement =driver.findElement(By.tagName("select"));
		Select select =new Select(selectWebElement);		
		String size=select.getFirstSelectedOption().getText();
		//productDetailsPojo.setSize(size);
		System.out.println(size);
		
		String colour=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'selected')]/a"))).getAttribute("name");
		//productDetailsPojo.setColour(colour);
		System.out.println(colour);
			
	}
}
