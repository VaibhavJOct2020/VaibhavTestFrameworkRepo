package vaibhav.framework.scripts;

import org.testng.annotations.Test;

import vaibhav.framework.pages.AuthenticationPage;
import vaibhav.framework.pages.HomePage;
import vaibhav.framework.pages.MyProfilePage;
import vaibhav.framework.pages.ProductCategoryPage;
import vaibhav.framework.pages.ProductDetailsPage;

public class E2EProductPurchaseTest extends TestBase {
	
	@Test
	public void productPurchase() {
		System.out.println("STEP-Login");
		HomePage homePage = new HomePage();
		System.out.println("STEP-Signing in");
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Providing username and passowrd");
		MyProfilePage myProfilePage = authenticationPage.doLogin("vaibhav23723@gmail.com", "DusKaDum");
		System.out.println("STEP-Clicking on women section");
		ProductCategoryPage productCategoryPage=myProfilePage.selectSection("Women");
		System.out.println("STEP-Select product");
		ProductDetailsPage productDetailsPage = productCategoryPage.selectByProductnumber(1);
		System.out.println("STEP-Capturing Product Details");
		productDetailsPage.captureDetails();
	}

}
