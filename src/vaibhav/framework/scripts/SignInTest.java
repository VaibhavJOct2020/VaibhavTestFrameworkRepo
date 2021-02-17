package vaibhav.framework.scripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import vaibhav.framework.base.PredefinedActions;
import vaibhav.framework.pages.AuthenticationPage;
import vaibhav.framework.pages.CreateAccountPage;
import vaibhav.framework.pages.HomePage;
import vaibhav.framework.pages.MyProfilePage;
import vaibhav.framework.pojo.CreateAccountDetailsPojo;

public class SignInTest  extends TestBase{
	CreateAccountDetailsPojo createAccountDetailsPojo;
	
	@Test
	public void signInValidation() {
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage=homePage.clickOnSignIn();		
		authenticationPage.enterEmailAddress("Vaibhav23723@gmail.com");
		CreateAccountPage createAccountPage=authenticationPage.createAnAccount();
		createAccountDetailsPojo = new CreateAccountDetailsPojo();
		createAccountDetailsPojo.setMale(true);
		createAccountDetailsPojo.setfirstName("Vaibhav");
		createAccountDetailsPojo.setLastName("Jagtap");
		createAccountDetailsPojo.setPassword("DusKaDum");
		createAccountDetailsPojo.setDay("10");
		createAccountDetailsPojo.setMonth("May ");
		createAccountDetailsPojo.setYear("1988");
		createAccountDetailsPojo.setCompany("TCS");
		createAccountDetailsPojo.setAddress("650 Grassmere park");
		createAccountDetailsPojo.setCity("nashville");
		createAccountDetailsPojo.setState("Tennessee");
		createAccountDetailsPojo.setPostCode("37211");
		createAccountDetailsPojo.setOtherInfo("N/A");
		createAccountDetailsPojo.setPhone("9890808555");
		createAccountDetailsPojo.setMobile("9890808555");		
		createAccountPage.enterPersonalDetails(createAccountDetailsPojo);		
		MyProfilePage myProfilePage = createAccountPage.clickOnRegistartion();
		String actual = myProfilePage.getHeaderText();
		String expected = "Vaibhav Jagtap";
		Assert.assertEquals(actual,expected,"first name and last name did not matched");
	}
	
	@Test
	public void signInUIValidation() {
		PredefinedActions.start();		
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage=homePage.clickOnSignIn();		
		authenticationPage.enterEmailAddress("Vaibhav23823@gmail.com");
		CreateAccountPage createAccountPage=authenticationPage.createAnAccount();
		createAccountPage.clickOnRegistartion();
		List<String>actualErrorMessage=createAccountPage.getErrorMessage();
		List<String> expectedErrorMessage = new ArrayList<String>();
		expectedErrorMessage.add("You must register at least one phone number.");
		expectedErrorMessage.add("lastname is required.");
		expectedErrorMessage.add("firstname is required.");
		expectedErrorMessage.add("passwd is required.");
		expectedErrorMessage.add("address1 is required.");
		expectedErrorMessage.add("city is required.");
		expectedErrorMessage.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		expectedErrorMessage.add("This country requires you to choose a State.");
		Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Messages are not Equal");
	}
}
