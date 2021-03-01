package vaibhav.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.utils.PropertyFileReader;

public class MyProfilePage extends PredefinedActions{
	
	private PropertyFileReader propertyFileReader;
	private static MyProfilePage myProfilePage;
	
	private MyProfilePage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.MYPROFILE_PAGE_PROPERTIES);		
	}
	
	public static MyProfilePage getInstance() {
		if(myProfilePage==null) {
			myProfilePage=new MyProfilePage();			
		}
		return myProfilePage;
	}
	
	public String getHeaderText() {
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		String actual = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyFileReader.getValue("headertext"))))
				.getText();*/
		/*WebElement actualElement = getElement(propertyFileReader.getValue("headertext"), true);
		String actual = actualElement.getText();*/
		String actual =getElementText(propertyFileReader.getValue("headertext"), true);
		return actual;
		
	}
	public ProductCategoryPage selectSection(String choice) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch(choice.toUpperCase()) {
		case "WOMEN":
			/*WebElement womenElement= getElement(propertyFileReader.getValue("women"), true);
			womenElement.click();*/
			clickOnElement(propertyFileReader.getValue("women"), true);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("women")))).click();	
			break;
		case "DRESSES":
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("dresses")))).click();
			/*WebElement dressesElement= getElement(propertyFileReader.getValue("dresses"), true);
			dressesElement.click();*/
			clickOnElement(propertyFileReader.getValue("dresses"), true);
			break;
		case "T-SHIRTS":
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyFileReader.getValue("tshirt")))).click();
			/*WebElement tshirtElement= getElement(propertyFileReader.getValue("tshirt"), true);
			tshirtElement.click();*/
			clickOnElement(propertyFileReader.getValue("tshirt"), true);
			break;
		default:
			break;
		}
		return ProductCategoryPage.getInstance();		
	}

}
