package vaibhav.framework.scripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import vaibhav.framework.pages.AddressPage;
import vaibhav.framework.pages.AuthenticationPage;
import vaibhav.framework.pages.HomePage;
import vaibhav.framework.pages.MyProfilePage;
import vaibhav.framework.pages.PayementPage;
import vaibhav.framework.pages.ProductCategoryPage;
import vaibhav.framework.pages.ProductDetailsPage;
import vaibhav.framework.pages.ShippingPage;
import vaibhav.framework.pages.ShoppingSummaryPage;


public class E2EProductPurchaseTest extends TestBase {
	
	@Test
	public void productPurchase() {
		System.out.println("STEP-Login");
		HomePage homePage = HomePage.getInstance();
		System.out.println("STEP-Signing in");
		AuthenticationPage authenticationPage =homePage.clickOnSignIn();
		System.out.println("STEP-Providing username and passowrd");
		MyProfilePage myProfilePage = authenticationPage.doLogin("vaibhav23723@gmail.com", "DusKaDum");
		//ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
		System.out.println("STEP-Clicking on women section");
		ProductCategoryPage productCategoryPage=myProfilePage.selectSection("Women");
		System.out.println("STEP-Select product");
		ProductDetailsPage productDetailsPage = productCategoryPage.selectByProductnumber(1);
		System.out.println("STEP-Set Quantity");
		productDetailsPage.setQuantity("10");
		System.out.println("STEP-Set Colour");
		productDetailsPage.setColour("Blue");
		System.out.println("STEP-Set Size");
		productDetailsPage.setSize("M");
		System.out.println("STEP-Capturing Details");
		ArrayList<String> expectedProductDetailsList=productDetailsPage.captureDetails();
		System.out.println("STEP-Addint To Cart");
		productDetailsPage.clickAddTocart();
		System.out.println("STEP-Verifying the details");
		ArrayList<String> actualProductDetailsList = productDetailsPage.verifyProductDetails();
		System.out.println("STEP-Comapring the actual and expected");
		Assert.assertEquals(expectedProductDetailsList, actualProductDetailsList);
		System.out.println("STEP-Proceeding to Checkout");
		ShoppingSummaryPage shoppingSummaryPage = productDetailsPage.proceedToCheckout();
		System.out.println("STEP-comapring product details on summary page");
		ArrayList<String>actualProductDetailsSummaryPage = shoppingSummaryPage.getProductDetailsOnSummaryPage();
		Assert.assertEquals(expectedProductDetailsList, actualProductDetailsSummaryPage);
		AddressPage addressPage = shoppingSummaryPage.proceedToCheckout();
		ArrayList <String>billingAddress = addressPage.verifyBillingAddress();
		ArrayList <String>deliveryAddress = addressPage.verifyDeliveryAddress();
		Assert.assertEquals(billingAddress, deliveryAddress);
		ShippingPage shippingPage= addressPage.proceedToCheckoutonAddressPage();
		shippingPage.acceptTermsOfService();
		PayementPage payementPage= shippingPage.proceedToCheckoutonShippingPage();
		payementPage.payByWire();
		payementPage.confirmTheOrder();		
	}

}
