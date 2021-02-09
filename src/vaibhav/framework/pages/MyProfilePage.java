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

}
