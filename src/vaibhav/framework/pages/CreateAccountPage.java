package vaibhav.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.pojo.CreateAccountDetailsPojo;

public class CreateAccountPage extends PredefinedActions{
	
	WebDriverWait wait;
	
	private void selectGender(boolean isMail) {
		wait = new WebDriverWait(driver,30);
		if(isMail) {
			System.out.println("STEP-Select Mr title");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))).click();
		}else {
			System.out.println("STEP-Select Ms title");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2"))).click();
		}		
	}	
	private void selectFirstName(String firstName) {
		System.out.println("STEP-Enter First Name");
		if(firstName!= null) {
			driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		}		
	}
	private void selectLastName(String lastName) {
		System.out.println("STEP-Enter Last Name");
		if(lastName!= null) {			
			driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		}
	}
	private void selectPassword(String password) {
		System.out.println("STEP-Enter Password");
		if(password!= null) {			
			driver.findElement(By.id("passwd")).sendKeys(password);	
		}
	}
	private void selectDay(String day) {
		System.out.println("STEP-Birthdate select");
		if(day!= null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-days")))).click();
			Select select = new Select(driver.findElement(By.cssSelector("#days")));
			select.selectByValue(day);
		}		
	}
	private void selectMonth(String month) {
		System.out.println("STEP-Birth month select");
		if(month!= null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-months"))).click();
			Select select = new Select(driver.findElement(By.id("months")));
			select.selectByVisibleText(month);
		}
	}
	private void selectYear(String year) {
		System.out.println("STEP-Birth year select");
		if(year != null) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-years"))).click();
			Select select = new Select(driver.findElement(By.id("years")));
			select.selectByValue(year);	
		}
	}
	private void selectCompany(String company) {
		System.out.println("STEP-Company Name is entered");
		if(company!= null) {
			driver.findElement(By.id("company")).sendKeys(company);
		}
	}
	private void selectAddress(String address) {
		System.out.println("STEP-Address Name is entered");
		if(address!= null) {			
			driver.findElement(By.id("address1")).sendKeys(address);
		}
	}
	private void selectCity(String city) {
		System.out.println("STEP-City Name is entered");
		if(city!= null) {
			driver.findElement(By.id("city")).sendKeys(city);
		}
	}
	private void selectState(String state) {
		System.out.println("STEP-Select a state");
		if(state != null ) {
			driver.findElement(By.id("uniform-id_state")).click();
			Select select = new Select(driver.findElement(By.id("id_state")));
			select.selectByVisibleText(state);
		}
	}	
	private void selectPostCode(String postCode) {
		System.out.println("STEP-Select Postcode");
		if(postCode!= null) {
			driver.findElement(By.id("postcode")).sendKeys(postCode);
		}
	}
	private void selectOtherInforamtion(String information) {
		System.out.println("STEP-Select Other information");
		if(information != null ) {
			driver.findElement(By.id("other")).sendKeys(information);
		}
	}
	private void selectHomePhone(String homePhone) {
		System.out.println("STEP-Home mobile number is entered");
		if(homePhone != null ) {
			driver.findElement(By.id("phone")).sendKeys(homePhone);		
		}
	}
	private void selectMobilePhone(String mobilePhone) {
		System.out.println("STEP-Mobile number is entered");
		if(mobilePhone!=null) {
			driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
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
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount"))).click();
		System.out.println("Details Registered in Application");
		return new MyProfilePage();
		
	}
	
	public List<String> getErrorMessage() {
					
		List<WebElement> errorMessageElementList = driver.findElements(By.cssSelector("ol>li"));
		List<String> actualErrorMessage = new ArrayList<String>();
		for(WebElement errorMessageElement : errorMessageElementList) {
			actualErrorMessage.add(errorMessageElement.getText());
		}
		return actualErrorMessage;
	}

}
