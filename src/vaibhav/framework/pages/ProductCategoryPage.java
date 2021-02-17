package vaibhav.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.exceptionhandling.ProductNotFoundException;

public class ProductCategoryPage extends PredefinedActions {
	List<WebElement>productList;
	
	public List<WebElement> getProductList() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("My Store"));
		productList = driver.findElements(By.cssSelector(".product_list.grid.row li img"));
		return productList;		
	}
	
	public ProductDetailsPage selectByProductnumber(int number) {
		getProductList();
		if(productList.size() > 0 && number < productList.size()) {
			number -= 1;
			WebElement productElement = productList.get(number);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productElement);
			return new ProductDetailsPage();
		}
		else
			throw new ProductNotFoundException("Product you Are looking for is not available");		
	}

}
