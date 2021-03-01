package vaibhav.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.exceptionhandling.ProductNotFoundException;
import vaibhav.framework.utils.PropertyFileReader;

public class ProductCategoryPage extends PredefinedActions {
	List<WebElement>productList;
	private PropertyFileReader propertyFileReader;
	private static ProductCategoryPage productCategoryPage;
	
	private ProductCategoryPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.PRODUCTCATEGORY_PAGE_PROPERTIES);		
	}
	
	public static ProductCategoryPage getInstance() {
		if(productCategoryPage==null) {
			productCategoryPage= new ProductCategoryPage();
		}
		return productCategoryPage;		
	}
	
	public List<WebElement> getProductList() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("My Store"));
		productList = driver.findElements(By.cssSelector(propertyFileReader.getValue("productlist")));
		return productList;		
	}
	
	public ProductDetailsPage selectByProductnumber(int number) {
		getProductList();
		if(productList.size() > 0 && number < productList.size()) {
			number -= 1;
			WebElement productElement = productList.get(number);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productElement);
			return ProductDetailsPage.getInstance();
		}
		else
			throw new ProductNotFoundException("Product you Are looking for is not available");		
	}

}
