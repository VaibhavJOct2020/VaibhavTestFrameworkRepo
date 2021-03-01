package vaibhav.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.constantPath.ConfigFilePath;
import vaibhav.framework.pojo.CreateAccountDetailsPojo;
import vaibhav.framework.utils.PropertyFileReader;

public class CreateAccountPage extends PredefinedActions{
	
	//private WebDriverWait wait;
	private PropertyFileReader propertyFileReader;
	private static CreateAccountPage createAccountPage;
	
	private CreateAccountPage(){
		propertyFileReader = new PropertyFileReader(ConfigFilePath.CREATEACCOUNT_PAGE_PROPERTIES);		
	}
	
	public static CreateAccountPage getInstance() {
		 if(createAccountPage==null) {
			 createAccountPage = new CreateAccountPage();
		 }
		 return createAccountPage;		 
	 }
	
	private void selectGender(boolean isMale) {
		//wait = new WebDriverWait(driver,30);
		if(isMale) {
			System.out.println("STEP-Select Mr title");
			//wait.until(ExpectedConditions.elementToBeClickable(By.id(propertyFileReader.getValue("male")))).click();
			/*WebElement selectGender =getElement(propertyFileReader.getValue("male"), true);
			selectGender.click();*/		
			clickOnElement(propertyFileReader.getValue("male"), true);
			
		}else {
			System.out.println("STEP-Select Ms title");
			//wait.until(ExpectedConditions.elementToBeClickable(By.id(propertyFileReader.getValue("female")))).click();
			/*WebElement selectGender =getElement(propertyFileReader.getValue("female"), true);
			selectGender.click();*/
			clickOnElement(propertyFileReader.getValue("female"), true);
		}		
	}	
	private void selectFirstName(String firstName) {
		System.out.println("STEP-Enter First Name");
		if(firstName!= null) {
			//driver.findElement(By.id(propertyFileReader.getValue("customerfirstname"))).sendKeys(firstName);
			/*WebElement firstNameElement = getElement(propertyFileReader.getValue("customerfirstname"),true);
			firstNameElement.sendKeys(firstName);*/
			enterText(propertyFileReader.getValue("customerfirstname"),true,firstName);
		}		
	}
	private void selectLastName(String lastName) {
		System.out.println("STEP-Enter Last Name");
		if(lastName!= null) {			
			//driver.findElement(By.id(propertyFileReader.getValue("customerlastname"))).sendKeys(lastName);
			/*WebElement lastNameElement = getElement(propertyFileReader.getValue("customerlastname"),true);
			lastNameElement.sendKeys(lastName)*/;
			enterText(propertyFileReader.getValue("customerlastname"),true,lastName);
		}
	}
	private void selectPassword(String password) {
		System.out.println("STEP-Enter Password");
		if(password!= null) {			
			//driver.findElement(By.id(propertyFileReader.getValue("customerpassword"))).sendKeys(password);	
			/*WebElement passwordElement = getElement(propertyFileReader.getValue("customerpassword"),true);
			passwordElement.sendKeys(password);*/
			enterText(propertyFileReader.getValue("customerpassword"),true,password);		
		}
	}
	private void selectDay(String day) {
		System.out.println("STEP-Birthdate select");
		if(day!= null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-days")))).click();
			WebElement dayElement = getElement(propertyFileReader.getValue("days"),true);
			Select select = new Select(dayElement);
			select.selectByValue(day);
		}		
	}
	private void selectMonth(String month) {
		System.out.println("STEP-Birth month select");
		if(month!= null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-months"))).click();
			WebElement monthElement = getElement(propertyFileReader.getValue("month"),true);
			Select select = new Select(monthElement);
			select.selectByVisibleText(month);
		}
	}
	private void selectYear(String year) {
		System.out.println("STEP-Birth year select");
		if(year != null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-years"))).click();
			//Select select = new Select(driver.findElement(By.id(propertyFileReader.getValue("year"))));
			WebElement yearElement = getElement(propertyFileReader.getValue("year"),true);
			Select select = new Select(yearElement);			
			select.selectByValue(year);	
		}
	}
	private void selectCompany(String company) {
		System.out.println("STEP-Company Name is entered");
		if(company!= null) {
			//driver.findElement(By.id(propertyFileReader.getValue("company"))).sendKeys(company);
			enterText(propertyFileReader.getValue("company"),true,company);
		}
	}
	private void selectAddress(String address) {
		System.out.println("STEP-Address Name is entered");
		if(address!= null) {			
			//driver.findElement(By.id(propertyFileReader.getValue("address"))).sendKeys(address);
			WebElement addressElement = getElement(propertyFileReader.getValue("address"), true);
			addressElement.sendKeys(address);
		}
	}
	private void selectCity(String city) {
		System.out.println("STEP-City Name is entered");
		if(city!= null) {
			//driver.findElement(By.id(propertyFileReader.getValue("city"))).sendKeys(city);
			/*WebElement cityElement = getElement(propertyFileReader.getValue("city"), true);
			cityElement.sendKeys(city);*/
			enterText(propertyFileReader.getValue("city"),true,city);
		}
	}
	private void selectState(String state) {
		System.out.println("STEP-Select a state");
		if(state != null ) {
			//driver.findElement(By.cssSelector(propertyFileReader.getValue("state"))).click();
			WebElement stateElement = getElement(propertyFileReader.getValue("state"),true);
			Select select = new Select(stateElement);
			select.selectByVisibleText(state);
		}
	}	
	private void selectPostCode(String postCode) {
		System.out.println("STEP-Select Postcode");
		if(postCode!= null) {
		/*	//driver.findElement(By.id(propertyFileReader.getValue("postcode"))).sendKeys(postCode);
			WebElement postCodeElement = getElement(propertyFileReader.getValue("postcode"), true);
			postCodeElement.sendKeys(postCode);*/
			enterText(propertyFileReader.getValue("postcode"),true,postCode);
		}
	}
	private void selectOtherInforamtion(String information) {
		System.out.println("STEP-Select Other information");
		if(information != null ) {
			//driver.findElement(By.id(propertyFileReader.getValue("other"))).sendKeys(information);
			/*WebElement otherInfoElement = getElement(propertyFileReader.getValue("other"), true);
			otherInfoElement.sendKeys(information);*/
			enterText(propertyFileReader.getValue("other"),true,information);
		}
	}
	private void selectHomePhone(String homePhone) {
		System.out.println("STEP-Home mobile number is entered");
		if(homePhone != null ) {
			//driver.findElement(By.id(propertyFileReader.getValue("phone"))).sendKeys(homePhone);
			/*WebElement homePhoneElement = getElement(propertyFileReader.getValue("phone"), true);
			homePhoneElement.sendKeys(homePhone);*/
			enterText(propertyFileReader.getValue("phone"),true,homePhone);
		}
	}
	private void selectMobilePhone(String mobilePhone) {
		System.out.println("STEP-Mobile number is entered");
		if(mobilePhone!=null) {
			//driver.findElement(By.id(propertyFileReader.getValue("mobile"))).sendKeys(mobilePhone);
			/*WebElement mobilePhoneElement = getElement(propertyFileReader.getValue("mobile"), true);
			mobilePhoneElement.sendKeys(mobilePhone);*/
			enterText(propertyFileReader.getValue("mobile"),true,mobilePhone);
		}
	}
	

	public void enterPersonalDetails(CreateAccountDetailsPojo createAccountDetailsPojo) {			
		selectGender(createAccountDetailsPojo.isMale());		
		selectFirstName(createAccountDetailsPojo.getfirstName());
		selectLastName(createAccountDetailsPojo.getLastName());
		selectPassword(createAccountDetailsPojo.getPassword());
		selectDay(createAccountDetailsPojo.getDay());
		selectMonth(createAccountDetailsPojo.getMonth());
		selectYear(createAccountDetailsPojo.getYear());
		selectCompany(createAccountDetailsPojo.getCompany());
		selectAddress(createAccountDetailsPojo.getAddress());
		selectCity(createAccountDetailsPojo.getCity());
		selectState(createAccountDetailsPojo.getState());
		selectPostCode(createAccountDetailsPojo.getPostCode());
		selectOtherInforamtion(createAccountDetailsPojo.getOtherInfo());
		selectHomePhone(createAccountDetailsPojo.getPhone());
		selectMobilePhone(createAccountDetailsPojo.getMobile());				
	}
	
	public MyProfilePage clickOnRegistartion() {
		/*wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(propertyFileReader.getValue("submitaccount")))).click();*/
		/*WebElement clickOnRegistartionElement = getElement(propertyFileReader.getValue("submitaccount"), true);
		clickOnRegistartionElement.click();*/
		clickOnElement(propertyFileReader.getValue("submitaccount"), true);
		System.out.println("Details Registered in Application");
		return MyProfilePage.getInstance();		
	}
	
	public List<String> getErrorMessage() {
					
		List<WebElement> errorMessageElementList = driver.findElements(By.cssSelector(propertyFileReader.getValue("errormessage")));
		List<String> actualErrorMessage = new ArrayList<String>();
		for(WebElement errorMessageElement : errorMessageElementList) {
			actualErrorMessage.add(errorMessageElement.getText());
		}
		return actualErrorMessage;
	}

}
