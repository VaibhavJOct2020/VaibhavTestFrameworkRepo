package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;

public class AuthenticationPage extends PredefinedActions{
	WebDriverWait wait;
	
	public void enterEmailAddress(String email) {
		WebElement emailElement = driver.findElement(By.id("email_create"));
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(emailElement));
		emailElement.sendKeys(email);
		System.out.println("email address Entered Successfully");		
	}
	
	public CreateAccountPage createAnAccount() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("SubmitCreate")))).click();
		System.out.println("Submit clicked Successfully");
		return new CreateAccountPage();
		
	}
}
