package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class MyProfilePage extends PredefinedActions{
	
	public String getHeaderText() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		String actual = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header_user_info span")))
				.getText();
		return actual;
		
	}
	public ProductCategoryPage selectSection(String choice) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch(choice.toUpperCase()) {
		case "WOMEN":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Categories')]//following-sibling::ul//*[contains(text(),'Women')]"))).click();	
			break;
		case "DRESSES":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Categories')]//following-sibling::ul//*[contains(text(),'Dresses')]"))).click();
			break;
		case "T-SHIRTS":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Categories')]//following-sibling::ul//*[contains(text(),'T-shirts')]"))).click();
			break;
		default:
			break;
		}
		return new ProductCategoryPage();		
	}

}
