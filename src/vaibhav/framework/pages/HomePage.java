package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class HomePage extends PredefinedActions  {
	
	public AuthenticationPage clickOnSignIn() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".header_user_info>a")))).click();
		System.out.println("Signed in Clicked Successfully");
		return new AuthenticationPage();
	}

}
