package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class AuthenticationPage extends PredefinedActions{
	private WebDriverWait wait;
	private PropertyFileReader propertyFileReader;
	private static AuthenticationPage authenticationPage;
	
	private  AuthenticationPage() {
		 propertyFileReader = new PropertyFileReader(ConfigFilePath.AUTHENTICATION_PAGE_PROPERTIES);
	}
	
	public static AuthenticationPage getInstance() {
		if(authenticationPage==null) {
			authenticationPage= new AuthenticationPage();
		}
		return authenticationPage;
	}
	
	public void enterEmailAddress(String email) {
		//WebElement emailElement = driver.findElement(By.id(propertyFileReader.getValue("createAccountemail")));
		/*wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(emailElement));*/
		//emailElement.sendKeys(email);
		WebElement emailElement = getElement(propertyFileReader.getValue("createAccountemail"), true);
		enterText(emailElement, email);	
		System.out.println("email address Entered Successfully");		
	}
	
	public CreateAccountPage createAnAccount() {
		/*wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(propertyFileReader.getValue("createAccountButton"))))).click();*/
		/*WebElement createAccountButton = getElement(propertyFileReader.getValue("createAccountButton"),true);
		createAccountButton.click();*/
		clickOnElement(propertyFileReader.getValue("createAccountButton"),true);
		System.out.println("Submit clicked Successfully");
		return CreateAccountPage.getInstance();		
	}
	
	public MyProfilePage doLogin(String email,String password) {		
		wait = new WebDriverWait(driver,30);
		enterEmail(email);
		enterPassword(password);
		clickSubmit();
		return MyProfilePage.getInstance();				
	}
	public void enterEmail(String email) {
	/*	wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("signInEmail")))).sendKeys(email);*/	
		//emailElement.sendKeys(email);
		WebElement emailElement = getElement(propertyFileReader.getValue("signInEmail"),true);
		enterText(propertyFileReader.getValue("signInEmail"),true,email);		
	}
	public void enterPassword(String password) {
		/*wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyFileReader.getValue("signInPassowrd")))).sendKeys(password);*/
		WebElement passwordElement = getElement(propertyFileReader.getValue("signInPassowrd"),true);
		passwordElement.sendKeys(password);		
	}
	public void clickSubmit() {
		/*wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(propertyFileReader.getValue("signInButton")))).click();*/	
		/*WebElement submitElement = getElement(propertyFileReader.getValue("signInButton"),true);
		submitElement.click();*/	
		clickOnElement(propertyFileReader.getValue("signInButton"),true);		
	}
	
	public ArrayList<String> getErrorMEssageOnAuthenticationPage() {
		List<WebElement> actualErrorMessagesElement =driver.findElements(By.cssSelector(propertyFileReader.getValue("signInError")));	//though it has one error message still added it in list for future reference
		ArrayList<String> actualErrorMessages = new ArrayList<String>();
		for(WebElement errorElement :actualErrorMessagesElement) {
			actualErrorMessages.add(errorElement.getText());			
		}
		return actualErrorMessages;
	}
}
