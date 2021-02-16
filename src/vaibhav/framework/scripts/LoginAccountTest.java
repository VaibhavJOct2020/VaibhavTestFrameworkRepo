package vaibhav.framework.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import vaibhav.framework.pages.AuthenticationPage;
import vaibhav.framework.pages.HomePage;
import vaibhav.framework.pages.MyProfilePage;

public class LoginAccountTest extends TestBase {
	
	@Test(enabled=false)
	public void verifyValidloginTest() {
		System.out.println("STEP-Login");
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Enter Username and passowrd");
		MyProfilePage myProfilePage = authenticationPage.doLogin("vaibhav23723@gmail.com", "DusKaDum");	
		String expected = "Vaibhav Jagtap";
		String actual=myProfilePage.getHeaderText();
		System.out.println("STEP-Validating User");
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void verifyInvalidEmailloginTest() {
		System.out.println("STEP-Login");
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Enter Username");
		authenticationPage.enterEmail("abc@gmail.com");
		System.out.println("STEP-Enter Password");
		authenticationPage.enterPassword("DusKaDum");
		System.out.println("STEP-Click Submit");
		authenticationPage.clickSubmit();
		List<String> expectedErrorMessage = new ArrayList<String>();
		expectedErrorMessage.add("Authentication failed.");
		List<String> actualErrorMessage=authenticationPage.getErrorMEssageOnAuthenticationPage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@Test
	public void verifyInvalidPasswordloginTest() {
		System.out.println("STEP-Login");
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Enter Username");
		authenticationPage.enterEmail("vaibhav23723@gmail.com");
		System.out.println("STEP-Enter Password");
		authenticationPage.enterPassword("nahibataunga");
		System.out.println("STEP-Click Submit");
		authenticationPage.clickSubmit();
		List<String> expectedErrorMessage = new ArrayList<String>();
		expectedErrorMessage.add("Authentication failed.");
		List<String> actualErrorMessage=authenticationPage.getErrorMEssageOnAuthenticationPage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@Test
	public void verifyBlankfieldsloginTest() {
		System.out.println("STEP-Login");
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Click Submit");
		authenticationPage.clickSubmit();
		List<String> expectedErrorMessage = new ArrayList<String>();
		expectedErrorMessage.add("An email address required.");	
		List<String> actualErrorMessage=authenticationPage.getErrorMEssageOnAuthenticationPage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
}
