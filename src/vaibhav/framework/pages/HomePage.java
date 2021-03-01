package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class HomePage extends PredefinedActions  {
	
	private PropertyFileReader propertyFileReader;
	private static HomePage homePage;
	
	private HomePage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.HOME_PAGE_PROPERTIES);		
	}
	
	public static HomePage getInstance(){
		if(homePage==null) {
			homePage= new HomePage();
		}
		return homePage;		
	}
	
	
	public AuthenticationPage clickOnSignIn() {
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(propertyFileReader.getValue("headerInfo"))))).click();*/
		/*WebElement signInelement = getElement(propertyFileReader.getValue("headerInfo"), true);
		signInelement.click();*/
		clickOnElement(propertyFileReader.getValue("headerInfo"), true);
		System.out.println("Signed in Clicked Successfully");
		return AuthenticationPage.getInstance();
	}

}
