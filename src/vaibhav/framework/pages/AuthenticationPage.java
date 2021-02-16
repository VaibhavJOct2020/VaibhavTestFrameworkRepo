package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
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
	
	public MyProfilePage doLogin(String email,String password) {		
		wait = new WebDriverWait(driver,30);
		enterEmail(email);
		enterPassword(password);
		clickSubmit();
		return new MyProfilePage();				
	}
	public void enterEmail(String email) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);		
	}
	public void enterPassword(String password) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))).sendKeys(password);
		
	}
	public void clickSubmit() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SubmitLogin"))).click();		
	}
	
	public ArrayList<String> getErrorMEssageOnAuthenticationPage() {
		List<WebElement> actualErrorMessagesElement =driver.findElements(By.cssSelector("ol>li"));	//though it has one error message still added it in list for future reference
		ArrayList<String> actualErrorMessages = new ArrayList<String>();
		for(WebElement errorElement :actualErrorMessagesElement) {
			actualErrorMessages.add(errorElement.getText());			
		}
		return actualErrorMessages;
	}
}
